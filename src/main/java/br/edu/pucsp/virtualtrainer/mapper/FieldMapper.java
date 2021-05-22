package br.edu.pucsp.virtualtrainer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.edu.pucsp.virtualtrainer.model.dto.FieldDto;
import br.edu.pucsp.virtualtrainer.model.entity.Field;

@Mapper
public interface FieldMapper {

    // TODO: não tá trazendo a categoria
    @Mapping(constant = "category", target = "category")
    FieldDto entityToDto(Field field);
    Field dtoToEntity(FieldDto fieldDto);
}
