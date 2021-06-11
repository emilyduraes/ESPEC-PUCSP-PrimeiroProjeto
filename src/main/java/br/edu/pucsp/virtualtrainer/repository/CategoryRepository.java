package br.edu.pucsp.virtualtrainer.repository;

import br.edu.pucsp.virtualtrainer.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
