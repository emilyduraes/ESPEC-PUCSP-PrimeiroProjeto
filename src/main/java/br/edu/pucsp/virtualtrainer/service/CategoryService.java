package br.edu.pucsp.virtualtrainer.service;

import java.util.List;

import br.edu.pucsp.virtualtrainer.domain.dto.CategoryDto;
import br.edu.pucsp.virtualtrainer.domain.dto.FieldDto;

public interface CategoryService {
    
    CategoryDto findCategory (Long categoryId);
    List<CategoryDto> findAllCategories();
    List<FieldDto> findFieldsByCategory(Long categoryId);
    
}
