package articleguide.restapi.dto;

import lombok.Data;

@Data
public class PasswordModifyDTO {
    private String nowPassword;
    private String modifiedPassword;
}
