package article_guide.article_guide_rest.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor//기본 생성자
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String userPassword;

    private String userName;

    private String userEmail;

    /*Entity 의 빌더패턴을 위한 필수 속성 생성자*/
    @Builder
    public User(String id, String password, String name, String email){
        this.userId = id;
        this.userPassword = password;
        this.userName = name;
        this.userEmail = email;
    }
}
