package articleguide.restapi.dto;

import articleguide.restapi.entity.Member;
import lombok.Data;

@Data
public class MemberForm {
    private String userId;
    private String password;
    private String name;
    private String email;
    private String role;

    public Member toEntity() {
        return Member.builder()
                .username(this.userId)
                .password(this.password)
                .name(this.name)
                .email(this.email)
                .role(this.role)
                .build();
    }
}
