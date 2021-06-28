package br.edu.pucsp.virtualtrainer.controller;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.pucsp.virtualtrainer.domain.request.LoginRequest;
import br.edu.pucsp.virtualtrainer.domain.response.LoginResponse;
import br.edu.pucsp.virtualtrainer.service.AuthUserService;
import io.swagger.annotations.ApiOperation;

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
}
