package br.edu.pucsp.virtualtrainer.repository;

import br.edu.pucsp.virtualtrainer.domain.entity.TrainerField;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerFieldRepository extends JpaRepository<TrainerField, Long> {
}
