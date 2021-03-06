package br.edu.pucsp.virtualtrainer.mapper;

import br.edu.pucsp.virtualtrainer.domain.dto.TrainerDto;
import br.edu.pucsp.virtualtrainer.domain.entity.Trainer;
import br.edu.pucsp.virtualtrainer.domain.request.TrainerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = FieldMapper.class)
public interface TrainerMapper {
    
    @Mapping(source = "birthDate", target = "birthdate")
    Trainer dtoToEntity(TrainerDto trainerDto);

    @Mapping(source = "birthdate", target = "birthDate")
    TrainerDto entityToDto(Trainer trainer);    
    Trainer requestToEntity(TrainerRequest request) ;
}