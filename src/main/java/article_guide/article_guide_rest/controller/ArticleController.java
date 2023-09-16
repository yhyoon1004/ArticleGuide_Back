package article_guide.article_guide_rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class ArticleController {
    @GetMapping
    public String main(){
        return "hello";
    }
}
