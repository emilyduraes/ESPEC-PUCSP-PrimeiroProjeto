package br.edu.pucsp.virtualtrainer.service;

import br.edu.pucsp.virtualtrainer.domain.request.LoginRequest;
import br.edu.pucsp.virtualtrainer.domain.response.LoginResponse;
import org.springframework.http.HttpStatus;

public interface AuthUserService {
    LoginResponse login(LoginRequest loginRequest);

    LoginResponse logout();
}
