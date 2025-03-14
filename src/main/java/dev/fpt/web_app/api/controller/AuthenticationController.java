package dev.fpt.web_app.api.controller;

import dev.fpt.web_app.api.resources.AuthenticationRequest;
import dev.fpt.web_app.api.resources.AuthenticationResponse;
import dev.fpt.web_app.api.resources.RegisterRequest;
import dev.fpt.web_app.application.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor

public class AuthenticationController {

    private final AuthenticationService authenticationService;


    @PostMapping("register")
    public ResponseEntity<AuthenticationResponse> register(
            @Valid @RequestBody RegisterRequest request

    ){
        return ResponseEntity.ok(authenticationService.register(request));
    }


    @PostMapping("authentication")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @Valid @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }


}
