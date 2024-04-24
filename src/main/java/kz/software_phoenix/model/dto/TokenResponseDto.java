package kz.software_phoenix.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TokenResponseDto {
    private String accessToken;
    private String refreshToken;
}
