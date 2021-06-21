package br.edu.pucsp.virtualtrainer.controller;


import br.edu.pucsp.virtualtrainer.domain.request.LoginRequest;
import br.edu.pucsp.virtualtrainer.domain.response.LoginResponse;
import br.edu.pucsp.virtualtrainer.service.AuthUserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Base64;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/auth")
public class AuthUserController {

    private static final Logger log = LoggerFactory.getLogger(AuthUserController.class);

    @Autowired
    AuthUserService authUserService;

    @ApiOperation(value = "Login")
    @PostMapping(path = "/login", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    public LoginResponse login(@RequestBody @Valid LoginRequest loginRequest){
        LoginResponse login = authUserService.login(loginRequest);
        log.info("Login: ",login);
        return login;
    }

    @ApiOperation(value = "Logout")
    @GetMapping(value = "/logout")
    @ResponseBody
    public LoginResponse processLogout() {
        LoginResponse response = authUserService.logout();
        return response;
    }

/*    @GetMapping(path = "/user")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();
        return () -> new String(Base64.getDecoder()
                .decode(authToken)).split(":")[0];
    }*/
}
