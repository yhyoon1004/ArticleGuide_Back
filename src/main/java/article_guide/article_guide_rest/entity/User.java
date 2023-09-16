package article_guide.article_guide_rest.entity;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String userPassword;

    private String userName;

    private String userEmail;
}
