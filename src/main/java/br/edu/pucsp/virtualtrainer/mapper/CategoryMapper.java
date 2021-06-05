package br.edu.pucsp.virtualtrainer.mapper;

import org.mapstruct.Mapper;

import br.edu.pucsp.virtualtrainer.model.dto.CategoryDto;
import br.edu.pucsp.virtualtrainer.model.entity.Category;

@Mapper
public interface CategoryMapper {
    
    CategoryDto entityToDto(Category category);
}
