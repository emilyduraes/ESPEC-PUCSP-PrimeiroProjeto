package br.edu.pucsp.virtualtrainer.repository;

import br.edu.pucsp.virtualtrainer.model.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {

    @Query("SELECT t FROM Trainer t WHERE lower(t.nickname) LIKE lower(concat('%', concat(:nickname, '%')))")
    Optional<List<Trainer>> findByNickname(@Param("nickname") String nickname);

}
