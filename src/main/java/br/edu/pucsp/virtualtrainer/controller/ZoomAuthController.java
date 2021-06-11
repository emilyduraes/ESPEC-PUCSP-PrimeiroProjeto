package br.edu.pucsp.virtualtrainer.controller;

import br.edu.pucsp.virtualtrainer.service.ZoomAuthService;
import br.edu.pucsp.virtualtrainer.domain.response.api.ZoomTokenResponse;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/zoom/auth")
public class ZoomAuthController {

    private ZoomAuthService service;

    public ZoomAuthController(ZoomAuthService service) {
        this.service = service;
    }

    @GetMapping
    public void getAuth(String clientId){
        service.requestAuthorization(clientId);
    }

    @GetMapping(path = "/callback")
    public ZoomTokenResponse receiveAuth(@RequestParam("code") String code,
                                         @RequestParam("state") String userId){
        return service.requestToken(code, userId);
    }

    @PostMapping(path = "/refresh")
    public ZoomTokenResponse refresh(@RequestParam("refreshToken") String refreshToken,
                                     @RequestParam("state") Long userId){
        return service.refreshToken(refreshToken, userId);
    }

    @GetMapping(path = "/deactivate")
    public void deactivate(){

    }
}
