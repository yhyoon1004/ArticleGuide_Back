package articleguide.restapi.service;

import articleguide.restapi.dto.MemberForm;
import articleguide.restapi.entity.Member;
import articleguide.restapi.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * 회원 등록 전 해당 아이디가 있는 지 확인하는 메서드
     */
    public Boolean isUserIdExist(String userId) {
        Optional<Member> searchedMember = memberRepository.findByUsername(userId);
        return searchedMember.isPresent();
    }

    public void signupMember(MemberForm mf) {
        Member member = Member.createMember(mf.getUserId(), mf.getPassword(), mf.getName(), mf.getEmail(), mf.getRole(), passwordEncoder);
        memberRepository.save(member);
    }
}
