package br.edu.pucsp.virtualtrainer.domain.request;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "LoginRequest", description = "Username and Password")
public class LoginRequest {

    @ApiModelProperty(name = "username")
    @NotEmpty(message = "The username cannot be null or empty")
    private String username;

    @ApiModelProperty(name = "password")
    @NotEmpty(message = "The password cannot be null or empty")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
