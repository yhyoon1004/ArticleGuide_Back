package articleguide.restapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    private String username;

    private String password;

    private String name;
    @Email
    private String email;



    @Builder
    public Member(String username, String password, String name, String email) {
        this.id=null;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
    }
}
