package br.edu.pucsp.virtualtrainer.service;

import java.util.List;

import br.edu.pucsp.virtualtrainer.model.dto.CategoryDto;
import br.edu.pucsp.virtualtrainer.model.dto.FieldDto;

public interface CategoryService {
    
    CategoryDto findCategory (Long id);
    List<CategoryDto> findAllCategories();
    List<FieldDto> findFieldsByCategory(Long categoryId);
    
}
