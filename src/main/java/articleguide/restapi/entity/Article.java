package articleguide.restapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;

@Entity
@RequiredArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private String title;
    private String content;
    private String summary;
    private String keyword;
    private String byline;
    @CreatedDate
    private Timestamp createdTime;
    @LastModifiedDate
    private Timestamp modifiedTime;

    @Builder
    public Article(String category,String title, String content, String byline, String keyword, String summary) {
        this.category =category;
        this.title = title;
        this.content = content;
        this.byline = byline;
        this.keyword = keyword;
        this.summary = summary;
    }

}
