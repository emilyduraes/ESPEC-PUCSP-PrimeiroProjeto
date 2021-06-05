package br.edu.pucsp.virtualtrainer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.pucsp.virtualtrainer.domain.entity.LiveClass;

public interface LiveClassRepository extends JpaRepository<LiveClass, Long> {

    @Query("SELECT l FROM LiveClass l WHERE lower(l.title) LIKE lower(concat('%', concat(:title, '%')))")
    Optional<List<LiveClass>> findByTitle(@Param("title") String title);
}