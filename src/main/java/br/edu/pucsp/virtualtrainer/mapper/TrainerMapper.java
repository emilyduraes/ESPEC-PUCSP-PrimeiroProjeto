package br.edu.pucsp.virtualtrainer.mapper;

import br.edu.pucsp.virtualtrainer.model.dto.TrainerDto;
import br.edu.pucsp.virtualtrainer.model.entity.Trainer;
import br.edu.pucsp.virtualtrainer.transport.request.TrainerRequest;
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