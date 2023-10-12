package articleguide.restapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Getter
@RequiredArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String password;

    private String name;
    @Email
    private String email;

    private String role;



    @Builder
    public Member(String userId, String password, String name, String email, String role) {
        this.id=null;
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public static Member createMember(String userId, String password, String name, String email, String role, PasswordEncoder passwordEncoder){
        return Member.builder()
                .userId(userId)
                .password(passwordEncoder.encode(password))
                .name(name)
                .email(email)
                .role(role)
                .build();
    }
}

