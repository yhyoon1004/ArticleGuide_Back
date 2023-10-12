package articleguide.restapi.controller;

import articleguide.restapi.auth.MemberAuth;
import articleguide.restapi.dto.MemberForm;
import articleguide.restapi.dto.MemberInfoDTO;
import articleguide.restapi.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

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


}
