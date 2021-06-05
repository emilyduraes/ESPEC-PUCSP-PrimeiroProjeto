package br.edu.pucsp.virtualtrainer.repository;

import java.util.List;

import br.edu.pucsp.virtualtrainer.domain.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FieldRepository extends JpaRepository<Field, Long> {

    @Query("SELECT f FROM Field f WHERE f.category.id = :categoryId")
    List<Field> findByCategory(Long categoryId);
}
