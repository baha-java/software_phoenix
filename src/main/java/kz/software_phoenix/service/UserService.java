package kz.software_phoenix.service;

import kz.software_phoenix.exception.NotFoundException;
import kz.software_phoenix.model.entity.User;
import kz.software_phoenix.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    @Transactional
    public void create(User user) {
        log.info("IN create - user: {}", user);
        userRepository.save(user);
    }

    public Optional<User> findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).
                orElseThrow(() -> new NotFoundException(String.format("Username %s not found", username)));
    }

    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException(String.format("Username %s not found", username)));
    }
}
