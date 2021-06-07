package br.edu.pucsp.virtualtrainer.service;

import br.edu.pucsp.virtualtrainer.domain.entity.ZoomToken;
import br.edu.pucsp.virtualtrainer.domain.response.api.ZoomTokenResponse;
import br.edu.pucsp.virtualtrainer.exception.DataNotFoundException;
import br.edu.pucsp.virtualtrainer.mapper.TokenMapper;
import br.edu.pucsp.virtualtrainer.repository.ZoomTokenRepository;
import br.edu.pucsp.virtualtrainer.service.api.ZoomAuthClient;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import static java.lang.String.join;
import static java.util.Base64.getEncoder;
import static java.util.Optional.ofNullable;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED;

@Service
public class ZoomAuthServiceImpl implements ZoomAuthService{

    private static final Logger log = LoggerFactory.getLogger(ZoomAuthServiceImpl.class);
    private static final TokenMapper MAPPER = Mappers.getMapper(TokenMapper.class);

    private static final String SERVER = "https://quick-liger-52.loca.lt";
    private static final String CONTEXT = "/virtual-trainer";
    private static final String REDIRECT_URL = SERVER + CONTEXT + "/zoom/auth/callback/";
    private static final String REFRESH_TOKEN = "refresh_token";
    private static final String AUTHORIZATION_CODE = "authorization_code";
    private static final String AUTHORIZATION = "Authorization";
    private static final String USER_STATE = "?state=";
    private static final String CODE = "code";
    private static final String CREDENTIAL_NAME = "Basic";

    @Value("${zoom.client.dev.id}")
    private String clientId;

    @Value("${zoom.client.dev.secret}")
    private String clientSecret;

    private final ZoomAuthClient zoomAuthClient;

    private final ZoomTokenRepository repository;

    public ZoomAuthServiceImpl(ZoomAuthClient zoomAuthClient, ZoomTokenRepository repository) {
        this.zoomAuthClient = zoomAuthClient;
        this.repository = repository;
    }

    @Override
    public void requestAuthorization(String userId) {
        String response = zoomAuthClient.getAuthorization(CODE, clientId, REDIRECT_URL + USER_STATE + userId);
        log.error(response);
    }

    @Override
    public ZoomTokenResponse requestToken(String code, String userId) {
        ZoomTokenResponse response = zoomAuthClient.createToken(getHeader(), AUTHORIZATION_CODE, code, REDIRECT_URL + USER_STATE + userId);
        var zoomToken = MAPPER.responseToEntity(response);
        repository.save(zoomToken);

        return response;
    }

    @Override
    public ZoomTokenResponse refreshToken(String refreshToken, Long userId) {
        return zoomAuthClient.refreshToken(getHeader(), REFRESH_TOKEN, refreshToken);
    }

    @Override
    public String getToken(Long clientId){
        //TODO se não houver token, tentar realizar o fluxo de autorização
        ZoomToken token = ofNullable(repository.findByTrainer(clientId))
                .orElseThrow(() -> new DataNotFoundException("Acesso ao zoom não liberado"));
        if(token.getExpirationDate().isBefore(LocalDateTime.now())){
            var zoomTokenResponse = refreshToken(token.getRefreshToken(), clientId);
            repository.save(MAPPER.updateEntity(zoomTokenResponse, token));
        }

        return token.getAccessToken();
    }

    private HttpHeaders getHeader() {
        var encodedValue = getEncoder().encodeToString(join(":", clientId, clientSecret).getBytes());

        var header = new HttpHeaders();
        header.add(AUTHORIZATION, join(" ", CREDENTIAL_NAME, encodedValue));
        header.setContentType(APPLICATION_FORM_URLENCODED);
        return header;
    }

}
