package br.edu.pucsp.virtualtrainer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.edu.pucsp.virtualtrainer.domain.dto.FieldDto;
import br.edu.pucsp.virtualtrainer.domain.entity.Field;

@Mapper
public interface FieldMapper {

    // TODO: não tá trazendo a categoria
    @Mapping(constant = "category", target = "category")
    FieldDto entityToDto(Field field);
    Field dtoToEntity(FieldDto fieldDto);
}
