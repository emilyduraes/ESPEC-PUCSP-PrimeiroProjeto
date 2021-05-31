package br.edu.pucsp.virtualtrainer.service;

import java.util.List;

import br.edu.pucsp.virtualtrainer.model.dto.CategoryDto;

public interface CategoryService {
    
    CategoryDto findCategory (Long id);
    List<CategoryDto> findAllCategories();
    
}
