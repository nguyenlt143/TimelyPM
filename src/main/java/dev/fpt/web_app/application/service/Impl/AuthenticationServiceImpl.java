package dev.fpt.web_app.application.service.Impl;

import dev.fpt.web_app.api.resources.AuthenticationRequest;
import dev.fpt.web_app.api.resources.AuthenticationResponse;
import dev.fpt.web_app.api.resources.RegisterRequest;
import dev.fpt.web_app.application.service.AuthenticationService;
import dev.fpt.web_app.application.service.JwtService;
import dev.fpt.web_app.domain.entity.Role;
import dev.fpt.web_app.domain.entity.User;
import dev.fpt.web_app.domain.enums.Role_Type;
import dev.fpt.web_app.domain.repository.RoleRepository;
import dev.fpt.web_app.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final RoleRepository roleRepository;



    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(), request.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
//        Role userRole = roleRepository.findByRoleName("USER")
//                .orElseThrow(() -> new RuntimeException("Role USER not found"));
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new UsernameNotFoundException("User already exists!");
        }

        var user = User.builder()
                .userName(request.getUserName())
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
//                .roles(Set.of(userRole))
                .isActive(false)
                .isBlocked(false)
                .createdAt(Instant.now())
                .build();

        User savedUser = userRepository.save(user);
        System.out.println("User saved: " + savedUser);

        String token = jwtService.generateToken(savedUser);
        System.out.println("Generated token: " + token);

        AuthenticationResponse response = AuthenticationResponse.builder()
                .token(token)
                .build();

        System.out.println("Created response: " + response);
        System.out.println("Token inside response: " + response.getToken());


        return response;
    }
}
