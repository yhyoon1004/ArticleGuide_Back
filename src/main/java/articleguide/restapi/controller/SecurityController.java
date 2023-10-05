package articleguide.restapi.controller;

import articleguide.restapi.dto.MemberForm;
import articleguide.restapi.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class SecurityController {
    private final MemberService memberService;
    @PostMapping("signup")
    @ResponseBody
    public String signup(@RequestBody MemberForm memberForm) {
        //가입하고자 하는 Id가 존재하면 회원가입 실패
        if(memberService.isUserIdExist(memberForm.getUserId())){
            return "signup failure";
        }
        memberService.signupMember(memberForm);
        return "signup success";
    }
}
