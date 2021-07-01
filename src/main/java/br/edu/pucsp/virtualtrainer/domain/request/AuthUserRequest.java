package br.edu.pucsp.virtualtrainer.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(value = "AuthUserRequest", description = "Transport class for AuthUser")
public class AuthUserRequest {

    @ApiModelProperty(name = "id")
    private Long id;

    @ApiModelProperty(name = "username")
    @NotEmpty(message = "The username (e-mail) cannot be null or empty")
    @Email(message = "This is not a valid email")
    private String username;

    @ApiModelProperty(name = "password")
    @NotEmpty(message = "The password cannot be null or empty")
    @Size(min = 6, max = 90, message = "A password should have minimum 6 characters")
    private String password;

    @ApiModelProperty(name = "role", example = "ROLE_STUDENT or ROLE_TRAINER")
    @NotEmpty(message = "The authorities cannot be null or empty")
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
