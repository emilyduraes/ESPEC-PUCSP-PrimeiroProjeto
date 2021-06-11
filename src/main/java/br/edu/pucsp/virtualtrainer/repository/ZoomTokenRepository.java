package br.edu.pucsp.virtualtrainer.repository;

import br.edu.pucsp.virtualtrainer.domain.entity.ZoomToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ZoomTokenRepository extends JpaRepository<ZoomToken, Long> {

    @Query("SELECT z FROM ZoomToken z WHERE z.trainer.id = :trainerId")
    ZoomToken findByTrainer(Long trainerId);

    @Query("SELECT z FROM ZoomToken z WHERE z.student.id = :studentId")
    ZoomToken findByStudent(Long studentId);
}
