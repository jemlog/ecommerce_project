package project.finaltoyproject.domain.user.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginDto {

    @NotEmpty
    private Long id;

    @Email
    @NotEmpty // null값, 빈칸, 공백 모두 허용하지 않기 위해 NotBlank 설정
    private String email;

    @NotEmpty
    private String password;


}
