package br.edu.pucsp.virtualtrainer.domain.response;

import br.edu.pucsp.virtualtrainer.domain.entity.Student;
import br.edu.pucsp.virtualtrainer.domain.entity.Trainer;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class AuthUserResponse {

    @JsonProperty("basic_authorization")
    private String basicAuthorization;
    @JsonProperty("authorities")
    private Collection<? extends GrantedAuthority> authorities;
    @JsonProperty("trainer")
    private Trainer trainer;
    @JsonProperty("student")
    private Student student;

    public String getBasicAuthorization() {
        return basicAuthorization;
    }

    public void setBasicAuthorization(String basicAuthorization) {
        this.basicAuthorization = basicAuthorization;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "AuthUserResponse{" +
                "basicAuthorization='" + basicAuthorization + '\'' +
                ", authorities=" + authorities +
                ", trainer=" + trainer +
                ", student=" + student +
                '}';
    }
}
