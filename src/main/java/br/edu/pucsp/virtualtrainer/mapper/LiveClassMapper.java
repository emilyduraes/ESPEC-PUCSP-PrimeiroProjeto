package br.edu.pucsp.virtualtrainer.mapper;

import org.mapstruct.Mapper;

import br.edu.pucsp.virtualtrainer.model.dto.LiveClassDto;
import br.edu.pucsp.virtualtrainer.model.entity.LiveClass;

@Mapper(uses = TrainerMapper.class)
public interface LiveClassMapper {

    LiveClassDto entityToDto(LiveClass liveClass);
    // LiveClass requestToEntity(LiveClassRequest request);

}
