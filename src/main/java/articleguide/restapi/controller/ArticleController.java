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

    /**
     * parameter submit type = request body - json
     * */
    @PostMapping("create")
    public boolean createArticle(@RequestBody ArticleForm articleForm) {
        return articleService.createArticle(articleForm);

    }

    /**
     * parameter submit type = request body - json
     * */
    @PostMapping("modify")
    public Boolean modifyArticle(@RequestBody ArticleForm articleForm) {
        return articleService.modifyArticle(articleForm);
    }

    /**
     * parameter submit type = request body - form-data
     * */
    @PostMapping("delete")
    public Boolean deleteArticle(@RequestParam long articleId) {
        return articleService.deleteArticle(articleId);
    }

}
