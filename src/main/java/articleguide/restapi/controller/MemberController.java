package articleguide.restapi.controller;

import articleguide.restapi.auth.MemberAuth;
import articleguide.restapi.dto.MemberForm;
import articleguide.restapi.dto.MemberInfoDTO;
import articleguide.restapi.dto.PasswordModifyDTO;
import articleguide.restapi.entity.Member;
import articleguide.restapi.repository.MemberRepository;
import articleguide.restapi.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     * */
    @PostMapping("signup")
    @ResponseBody
    public Boolean signup(@RequestBody MemberForm memberForm) {
        //가입하고자 하는 Id가 존재하면 회원가입 실패
        if(memberService.isUserIdExist(memberForm.getUserId())){
            return false;
        }
        memberService.signupMember(memberForm);
        return true;
    }


    /**
     * 사용자 정보 확인
     */
    @GetMapping("info/{userId}")
    @ResponseBody
    @MemberAuth
    public MemberInfoDTO userInfo(@PathVariable String userId) {
        return memberService.getUserInfo(userId);
    }


    /**
     * 비밀번호 변경
     */
    @PostMapping("/password/change")
    public Boolean modifyPassword(@AuthenticationPrincipal UserDetails userDetails, @RequestBody PasswordModifyDTO pmDTO) {
        Optional<Member> findUser = memberRepository.findByUserId(userDetails.getUsername());
        return null;
    }

    /**
     * 비밀번호 분실시 초기화
     * */
    @PostMapping("password/reset")
    @ResponseBody
    public String resetPassword() {
        //임의 문자열 생성 후, 반환해주는 서비스 필요
        return null;
    }

}
