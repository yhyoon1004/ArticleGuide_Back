package articleguide.restapi.service;

import articleguide.restapi.dto.MemberForm;
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> byUsername = memberRepository.findByUsername(username);
        Member tm = byUsername.orElseThrow(() -> new UsernameNotFoundException("등록되지 않은 사용자"));
        return User.builder()
                .username(tm.getUsername())
                .password(tm.getPassword())
                .roles(tm.getRole())
                .build()
                ;
    }

    /**
     * 회원 등록 전 해당 아이디가 있는 지 확인하는 메서드
     */
    public Boolean isUserIdExist(String userId) {
        Optional<Member> searchedMember = memberRepository.findByUsername(userId);
        return searchedMember.isPresent();
    }

    /**
     * 회원 등록 메서드
     * */
    public void signupMember(MemberForm mf) {
        Member member = Member.createMember(mf.getUserId(), mf.getPassword(), mf.getName(), mf.getEmail(), mf.getRole(), passwordEncoder);
        memberRepository.save(member);
    }
}
