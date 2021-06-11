package br.edu.pucsp.virtualtrainer.mapper;

import org.mapstruct.Mapper;

import br.edu.pucsp.virtualtrainer.domain.dto.CategoryDto;
import br.edu.pucsp.virtualtrainer.domain.entity.Category;

@Mapper
public interface CategoryMapper {
    
    CategoryDto entityToDto(Category category);
}
