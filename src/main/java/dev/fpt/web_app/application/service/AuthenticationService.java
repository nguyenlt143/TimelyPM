package dev.fpt.web_app.application.service;

import dev.fpt.web_app.api.resources.AuthenticationRequest;
import dev.fpt.web_app.api.resources.AuthenticationResponse;
import dev.fpt.web_app.api.resources.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service

public interface AuthenticationService {

    public AuthenticationResponse authenticate(AuthenticationRequest request);

    public AuthenticationResponse register(RegisterRequest request);
}
