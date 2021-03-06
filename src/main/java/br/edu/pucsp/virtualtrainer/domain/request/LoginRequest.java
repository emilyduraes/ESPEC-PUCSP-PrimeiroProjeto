package br.edu.pucsp.virtualtrainer.domain.request;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "LoginRequest", description = "E-mail and Password")
public class LoginRequest {

    @ApiModelProperty(name = "email")
    @NotEmpty(message = "The e-mail cannot be null or empty")
    private String email;

    @ApiModelProperty(name = "password")
    @NotEmpty(message = "The password cannot be null or empty")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
