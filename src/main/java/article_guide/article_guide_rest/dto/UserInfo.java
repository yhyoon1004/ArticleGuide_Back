package article_guide.article_guide_rest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfo {
    private String userId;
    private String userPassword;
    private String userName;
    private String userEmail;
}
