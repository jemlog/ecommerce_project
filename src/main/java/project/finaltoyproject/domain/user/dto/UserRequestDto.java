package project.finaltoyproject.domain.user.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserRequestDto {

    @NotEmpty
    @Length(max = 10)
    private String username;

    @NotEmpty
    @Length(max = 20)
    private String nickname;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    @Length(max = 255)
    private String password;

}
