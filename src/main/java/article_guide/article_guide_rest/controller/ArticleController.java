package article_guide.article_guide_rest.controller;

import article_guide.article_guide_rest.dto.UserInfo;
import article_guide.article_guide_rest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController("/")
@RequiredArgsConstructor
public class ArticleController {
    private final UserService userService;

    @GetMapping
    public String main() {
        return "hello";
    }

    /**
     * 회원가입하기
     * POST-JSON값으로 회원 정보 전송
     * */
    @PostMapping(value = "/sign_up", consumes = "application/json")
    public String userSignUp(@RequestBody UserInfo userInfo) {
        System.out.println("userInfo = " + userInfo.getUserId());
        userService.signUpService(userInfo);
        return "OK";
    }

    /**
     * 아이디로 회원 정보 찾기
     * @param userId
     * @return
     */
    @GetMapping("/userInfo/{userId}")
    public String userInfo(@PathVariable String userId){
        boolean isOk = userService.findUserInformation(userId);
        return "OK";
    }

}