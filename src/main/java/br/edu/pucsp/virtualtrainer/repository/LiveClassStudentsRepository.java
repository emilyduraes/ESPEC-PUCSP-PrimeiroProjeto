package br.edu.pucsp.virtualtrainer.repository;

import br.edu.pucsp.virtualtrainer.domain.entity.LiveClassStudents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LiveClassStudentsRepository extends JpaRepository<LiveClassStudents, Long> {

}