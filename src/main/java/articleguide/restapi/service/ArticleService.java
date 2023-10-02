package articleguide.restapi.service;

import articleguide.restapi.dto.ArticleForm;
import articleguide.restapi.entity.Article;
import articleguide.restapi.entity.Member;
import articleguide.restapi.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    public void createArticle(ArticleForm articleForm) {
        Article article = articleForm.toEntity();
        articleRepository.save(article);
    }
}
