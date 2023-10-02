package articleguide.restapi.controller;

import articleguide.restapi.dto.ArticleForm;
import articleguide.restapi.entity.Article;
import articleguide.restapi.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/article/*")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("test")
    @ResponseBody
    public String testHandle(){
        return "test OK!";
    }

    @PostMapping("create")
    public String createArticle(@RequestBody ArticleForm articleForm) {
        articleService.createArticle(articleForm);
        return "";
    }

}
