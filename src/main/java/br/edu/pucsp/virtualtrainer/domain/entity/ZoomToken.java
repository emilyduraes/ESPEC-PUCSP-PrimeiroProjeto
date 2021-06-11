package br.edu.pucsp.virtualtrainer.domain.entity;


import javax.persistence.*;
import java.time.LocalDateTime;
import static java.time.temporal.ChronoUnit.*;

@Entity
@Table(name = "zoom_token")
public class ZoomToken {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "trainer", referencedColumnName = "id")
    private Trainer trainer;
    @OneToOne
    @JoinColumn(name = "student", referencedColumnName = "id")
    private Student student;
    @Column(nullable = false, name = "access_token")
    private String accessToken;
    @Column(nullable = false, name = "refresh_token")
    private String refreshToken;
    @Column(nullable = false, name = "expiration_date")
    private LocalDateTime expirationDate;

    public ZoomToken() {
    }

    public ZoomToken(Trainer trainer, Student student, String accessToken, String refreshToken, Integer expiresIn) {
        this.trainer = trainer;
        this.student = student;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expirationDate = LocalDateTime.now().plus(expiresIn, SECONDS);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Integer expiresIn) {
        this.expirationDate = LocalDateTime.now().plus(expiresIn, SECONDS);
    }
}
