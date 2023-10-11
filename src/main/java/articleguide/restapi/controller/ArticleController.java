package articleguide.restapi.controller;

import articleguide.restapi.auth.MemberAuth;
import articleguide.restapi.dto.ArticleForm;
import articleguide.restapi.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/article/*")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("create")
    @MemberAuth
    public String createArticle(@RequestBody ArticleForm articleForm) {
        articleService.createArticle(articleForm);
        return "";
    }

}
