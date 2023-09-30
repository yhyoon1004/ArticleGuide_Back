package articleguide.restapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/article/*")
public class ArticleController {
    @GetMapping("test")
    public String testHandle(){
        return "test OK!";
    }
}
