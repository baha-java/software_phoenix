package kz.software_phoenix.model.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
@ToString
public class SignUpRequestDto {

    @Size(min = 5, max = 50, message = "Имя пользователя должно содержать от 5 до 50 символов")
    @NotBlank(message = "Имя пользователя не может быть пустыми")
    private String username;

    @NotBlank
    @Size(min = 8, max = 20)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$", message = "Пароль должен содержать как минимум одну цифру, одну строчную и одну заглавную букву")
    private String password;
    @NotBlank
    @Size(min = 8, max = 20)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$", message = "Пароль должен содержать как минимум одну цифру, одну строчную и одну заглавную букву")
    private String confirmPassword;
    @NotBlank
    private String fullName;
    @NotBlank
    @URL(message = "Ссылка должна быть в формате URL")
    private String link;
}
