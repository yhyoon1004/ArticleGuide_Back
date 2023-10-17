package articleguide.restapi.service;

import articleguide.restapi.dto.MemberForm;
import articleguide.restapi.dto.MemberInfoDTO;
import articleguide.restapi.entity.Member;
import articleguide.restapi.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * UserDetails 를 이용한 회원 정보를 읽어오는 메서드
     * */
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Optional<Member> byUsername = memberRepository.findByUserId(userId);
        Member tm = byUsername.orElseThrow(() -> new UsernameNotFoundException("등록되지 않은 사용자"));
        return User.builder()
                .username(tm.getUserId())
                .password(tm.getPassword())
                .roles(tm.getRole())
                .build();
    }

    /**
     * 회원 등록 전 해당 아이디가 있는 지 확인하는 메서드
     */
    public Boolean isUserIdExist(String userId) {
        Optional<Member> searchedMember = memberRepository.findByUserId(userId);
        return searchedMember.isPresent();
    }

    /**
     * 회원 등록 메서드
     * */
    public void signupMember(MemberForm mf) {
        Member member = Member.createMember(mf.getUserId(), mf.getPassword(), mf.getName(), mf.getEmail(), mf.getRole(), passwordEncoder);
        memberRepository.save(member);
    }

    /**
     * 회원 정보 조회 메서드
     */
    public MemberInfoDTO getUserInfo(String userId) {
        Optional<Member> result = memberRepository.findByUserId(userId);
        //만약 해당 아이디의 회원이 존재하지 않으면 null 반환
        if(result.isEmpty())return null;

        Member member = result.get();
        MemberInfoDTO info = MemberInfoDTO
                .builder()
                .userId(member.getUserId())
                .name(member.getName())
                .email(member.getEmail())
                .role(member.getRole())
                .build();

        return info;
    }

    /**
     * 비밀번호 변경 서비스 로직*/
    public void changePassword(UserDetails user, String newPassword) {
        //기존 비밀번호 확인 분기 + 새 비밀번호 암호화 후 적용 로직
    }
}
