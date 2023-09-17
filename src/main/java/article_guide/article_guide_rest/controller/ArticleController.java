package article_guide.article_guide_rest.controller;

import article_guide.article_guide_rest.dto.UserInfo;
import article_guide.article_guide_rest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
@RequiredArgsConstructor
public class ArticleController {
    private final UserService userService;

    @GetMapping
    public String main() {
        return "hello";
    }

    @PostMapping(value = "/sign_up", consumes = "application/json")
    public String userSignUp(@RequestBody UserInfo userInfo) {
        System.out.println("userInfo = " + userInfo.getUserId());
        userService.signUpService(userInfo);
        return "OK";
    }
}