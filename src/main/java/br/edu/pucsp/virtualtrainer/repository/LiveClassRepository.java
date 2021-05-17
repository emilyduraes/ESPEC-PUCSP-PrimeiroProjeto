package br.edu.pucsp.virtualtrainer.repository;

import br.edu.pucsp.virtualtrainer.model.entity.LiveClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LiveClassRepository extends JpaRepository<LiveClass, Long> {
}
