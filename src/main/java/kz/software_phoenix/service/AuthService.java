package kz.software_phoenix.service;

import kz.software_phoenix.exception.AuthenticationException;
import kz.software_phoenix.exception.DuplicateEntityException;
import kz.software_phoenix.exception.UserInputException;
import kz.software_phoenix.model.dto.SignInRequestDto;
import kz.software_phoenix.model.dto.SignUpRequestDto;
import kz.software_phoenix.model.dto.TokenResponseDto;
import kz.software_phoenix.model.entity.User;
import kz.software_phoenix.model.enumeration.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;


    public void signUp(SignUpRequestDto signUpRequestDto) {
        if(!signUpRequestDto.getPassword().equals(signUpRequestDto.getConfirmPassword())) {
            throw new UserInputException("Passwords do not match");
        }


        if(userService.findByUserName(signUpRequestDto.getUsername()).isPresent()) {
            throw new DuplicateEntityException("Username is already in use");
        }


        User user = User.builder()
                .username(signUpRequestDto.getUsername())
                .password(passwordEncoder.encode(signUpRequestDto.getPassword()))
                .fullName(signUpRequestDto.getFullName())
                .link(signUpRequestDto.getLink())
                .role(Role.ROLE_USER)
                .createdAt(LocalDateTime.now())
                .build();
        userService.create(user);
    }

    public TokenResponseDto signIn(SignInRequestDto signInRequestDto) {
        log.info("IN signIN - request:{}", signInRequestDto.getUsername());
        User user = userService.findByUsername(signInRequestDto.getUsername());

        if(!passwordEncoder.matches(signInRequestDto.getPassword(), user.getPassword())) {
            throw new AuthenticationException("Wrong password");
        }

        return TokenResponseDto.builder()
                .accessToken(jwtService.generateAccessToken(user))
                .refreshToken(jwtService.generateRefreshToken(new HashMap<>(), user))
                .build();
    }
}
