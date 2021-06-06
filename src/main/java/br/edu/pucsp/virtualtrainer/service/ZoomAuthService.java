package br.edu.pucsp.virtualtrainer.service;

import br.edu.pucsp.virtualtrainer.domain.response.api.ZoomTokenResponse;

public interface ZoomAuthService {

    void requestAuthorization(String clientId);
    ZoomTokenResponse requestToken(String code, String userId);
    ZoomTokenResponse refreshToken(String refreshToken, Long userId);
    String getToken(Long clientId);
}
