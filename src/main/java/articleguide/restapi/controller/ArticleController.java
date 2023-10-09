package articleguide.restapi.controller;

import articleguide.restapi.authentication.MemberAuth;
import articleguide.restapi.dto.ArticleForm;
import articleguide.restapi.entity.Article;
import articleguide.restapi.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/article/*")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @MemberAuth
    @GetMapping("test")
    public String sampleTest() {
        return "is OK";
    }

    @PostMapping("create")
    @MemberAuth
    public String createArticle(@RequestBody ArticleForm articleForm) {
        articleService.createArticle(articleForm);
        return "";
    }

}
