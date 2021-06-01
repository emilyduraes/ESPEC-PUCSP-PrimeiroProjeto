package br.edu.pucsp.virtualtrainer.mapper;

import org.mapstruct.Mapper;

import br.edu.pucsp.virtualtrainer.model.dto.FieldDto;
import br.edu.pucsp.virtualtrainer.model.entity.Field;

@Mapper(uses = CategoryMapper.class)
public interface FieldMapper {

    FieldDto entityToDto(Field field);
    Field dtoToEntity(FieldDto fieldDto);
}
