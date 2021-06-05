package br.edu.pucsp.virtualtrainer.repository;

import br.edu.pucsp.virtualtrainer.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
