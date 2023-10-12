package articleguide.restapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberInfoDTO {
    private String userId;
    private String name;
    private String email;
    private String role;
}
