package kz.software_phoenix.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Authentication", description = "The Authentication API. Contains operations like sign up and sign in.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticateController {
    private final AuthService authService;

    @Operation(summary = "User Registration", description = "Register the user.")
    @PostMapping("/signup")
    public ResponseEntity<HttpStatus> signup(@RequestBody @Valid SignUpRequestDto signUpRequestDto) {
        log.info("IN signup - request: {}", signUpRequestDto);
        authService.signUp(signUpRequestDto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @Operation(summary = "User Authentication", description = "Authenticate the user and return a JWT tokens if the user is valid.")
    @PostMapping("/signin")
    public ResponseEntity<TokenResponseDto> signin(@RequestBody @Valid SignInRequestDto signInRequestDto) {
        log.info("IN signin - request: {}", signInRequestDto);
        return ResponseEntity.ok(authService.signIn(signInRequestDto));
    }
}
