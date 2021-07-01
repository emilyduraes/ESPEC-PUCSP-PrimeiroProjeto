package br.edu.pucsp.virtualtrainer.service;

import br.edu.pucsp.virtualtrainer.domain.request.AuthUserRequest;
import br.edu.pucsp.virtualtrainer.domain.request.LoginRequest;
import br.edu.pucsp.virtualtrainer.domain.response.LoginResponse;

public interface AuthUserService {

    void createAuthUser(AuthUserRequest authUserRequest);
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse logout();
}
