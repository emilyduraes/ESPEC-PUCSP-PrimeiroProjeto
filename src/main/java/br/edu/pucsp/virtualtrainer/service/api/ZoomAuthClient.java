package br.edu.pucsp.virtualtrainer.service.api;

import br.edu.pucsp.virtualtrainer.config.FeignConfig;
import br.edu.pucsp.virtualtrainer.transport.response.api.ZoomTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient (value = "ZoomAuthClient", url = "https://zoom.us/oauth", configuration = FeignConfig.class)
public interface ZoomAuthClient {

    @GetMapping(path = "/authorize")
    String getAuthorization(@RequestParam(value = "response_type") String responseType,
                            @RequestParam(value = "client_id") String clientId,
                            @RequestParam(value = "redirect_uri") String redirectUri);


    @PostMapping(path = "/token")
    ZoomTokenResponse createToken(@RequestHeader HttpHeaders header,
                                  @RequestParam(value = "grant_type") String grantType,
                                  @RequestParam(value = "code") String code,
                                  @RequestParam(value = "redirect_uri") String redirectUri);

    @PostMapping(path = "/token")
    ZoomTokenResponse refreshToken(@RequestHeader HttpHeaders header,
                                   @RequestParam(value = "grant_type") String grantType,
                                   @RequestParam(value = "refresh_token") String refreshToken);
}
