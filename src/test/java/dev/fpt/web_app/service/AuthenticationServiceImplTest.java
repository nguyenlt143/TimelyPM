package dev.fpt.web_app.service;

import dev.fpt.web_app.api.resources.AuthenticationResponse;
import dev.fpt.web_app.api.resources.RegisterRequest;
import dev.fpt.web_app.application.service.Impl.AuthenticationServiceImpl;
import dev.fpt.web_app.application.service.JwtService;
import dev.fpt.web_app.domain.entity.User;
import dev.fpt.web_app.domain.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthenticationServiceImplTest {

    @Mock
    private  UserRepository userRepository;

    @Mock
    private  PasswordEncoder passwordEncoder;

    @Mock
    private  JwtService jwtService;

    @Mock
    private  AuthenticationManager authenticationManager;

    @InjectMocks
    private AuthenticationServiceImpl underTest;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void register_NewUser_ShouldReturnToken() {

        RegisterRequest registerRequest = new RegisterRequest("nguyen", "nguyen143@gmail.com", "Abcd@1234");
        when(userRepository.findByEmail(registerRequest.getEmail())).thenReturn(Optional.empty());

        when(passwordEncoder.encode(registerRequest.getPassword())).thenReturn("hashed-password");

        when(jwtService.generateToken(any(User.class))).thenReturn("mocked-jwt-token");

        AuthenticationResponse response = underTest.register(registerRequest);


        assertNotNull(response);
        assertNotNull(response.getToken());

        verify(userRepository, times(1)).save(argThat(user ->
                user.getUsername().equals(registerRequest.getUserName()) &&
                        user.getPasswordHash().equals("hashed-password") &&
                        user.getEmail().equals(registerRequest.getEmail()) &&
                        !user.isActive() &&
                        !user.isBlocked()
        ));

    }

}
