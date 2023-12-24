package articleguide.restapi.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Article extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    @Column(length = 50000)

    private String title;
    @Column(length = 500000)
    private String content;
    @Column(length = 10000)

    private String summary;
    private String keyword;
    private String byline;


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
