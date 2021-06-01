package br.edu.pucsp.virtualtrainer.service;

import br.edu.pucsp.virtualtrainer.service.api.ZoomAuthClient;
import br.edu.pucsp.virtualtrainer.transport.response.api.ZoomTokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class ZoomAuthServiceImpl implements ZoomAuthService{

    private static final Logger log = LoggerFactory.getLogger(ZoomAuthServiceImpl.class);
    private static final String SERVER = "https://red-elephant-16.loca.lt";
    private static final String CONTEXT = "/virtual-trainer";
    private static final String REDIRECT_URL = SERVER + CONTEXT + "/zoom/auth/callback/";
    private static final String REFRESH_TOKEN = "refresh_token";
    private static final String AUTHORIZATION_CODE = "authorization_code";
    private static final String AUTHORIZATION = "Authorization";
    private static final String USER_STATE = "?state=";
    private static final String CODE = "code";

    @Value("${zoom.client.id}")
    private String clientId;

    @Value("${zoom.client.secret}")
    private String clientSecret;

    private final ZoomAuthClient zoomAuthClient;

    public ZoomAuthServiceImpl(ZoomAuthClient zoomAuthClient) {
        this.zoomAuthClient = zoomAuthClient;
    }

    @Override
    public void requestAuthorization(String userId) {
        String response = zoomAuthClient.getAuthorization(CODE, clientId, REDIRECT_URL + USER_STATE + userId);
        log.error(response);
    }

    @Override
    public ZoomTokenResponse requestToken(String code, String userId) {
        var encodedValue = Base64.getEncoder().encodeToString((clientId + ":" + clientSecret).getBytes());
        String authValue = "Basic " + encodedValue;

        var header = new HttpHeaders();
        header.add(AUTHORIZATION, authValue);
        header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        return zoomAuthClient.createToken(header, AUTHORIZATION_CODE, code, REDIRECT_URL + USER_STATE + userId);
        //TODO onde armazenar o token e o refreshToken?
    }

    @Override
    @Cacheable(value = "token", key = "#userId")
    public ZoomTokenResponse refreshToken(String refreshToken, String userId) {
        var encodedValue = Base64.getEncoder().encodeToString((clientId + ":" + clientSecret).getBytes());
        String authValue = "Basic " + encodedValue;

        var header = new HttpHeaders();
        header.add(AUTHORIZATION, authValue);
        header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        return zoomAuthClient.refreshToken(header, REFRESH_TOKEN, refreshToken);
    }

    public String getToken(){
        return "";
    }
}
