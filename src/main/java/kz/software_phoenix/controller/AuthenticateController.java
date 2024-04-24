package kz.software_phoenix.controller;

import jakarta.validation.Valid;
import kz.software_phoenix.model.dto.SignInRequestDto;
import kz.software_phoenix.model.dto.SignUpRequestDto;
import kz.software_phoenix.model.dto.TokenResponseDto;
import kz.software_phoenix.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticateController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<HttpStatus> signup(@RequestBody @Valid SignUpRequestDto signUpRequestDto) {
        log.info("IN signup - request: {}", signUpRequestDto);
        authService.signUp(signUpRequestDto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<TokenResponseDto> signin(@RequestBody @Valid SignInRequestDto signInRequestDto) {
        log.info("IN signin - request: {}", signInRequestDto);
        return ResponseEntity.ok(authService.signIn(signInRequestDto));
    }
}
