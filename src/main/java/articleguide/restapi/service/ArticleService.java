package articleguide.restapi.service;

import articleguide.restapi.dto.ArticleForm;
import articleguide.restapi.entity.Article;
import articleguide.restapi.entity.Member;
import articleguide.restapi.repository.ArticleRepository;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    /**
     * 기사 생성
     * */
    @Transactional

    public boolean createArticle(ArticleForm articleForm) {
        Article article = articleForm.toEntity();
        articleRepository.save(article);
        Optional<Article> byId = articleRepository.findById(articleForm.getArticleId());
        return byId.isPresent();
    }

    /**
     * 기사 수정
     */
    @Transactional
    public boolean modifyArticle(ArticleForm modifiedArticle) {
        Long articleId = modifiedArticle.getArticleId();
        Optional<Article> findArticleOptional = articleRepository.findById(articleId);
        if(findArticleOptional.isEmpty()) return false;

        Article article = findArticleOptional.get();
        article.setTitle(modifiedArticle.getTitle());
        article.setCategory(modifiedArticle.getCategory());
        article.setContent(modifiedArticle.getContent());
        article.setByline(modifiedArticle.getByline());
        article.setKeyword(modifiedArticle.getKeyword());

        return true;
    }

    /**
     * 기사 삭제
     * */
    @Transactional
    public boolean deleteArticle(Long articleId) {
        Optional<Article> findArticle = articleRepository.findById(articleId);
        if(findArticle.isEmpty()) return false;

        articleRepository.deleteById(articleId);
        Optional<Article> deleteAfter = articleRepository.findById(articleId);
        return deleteAfter.isEmpty()? true: false;
    }
}
