package br.edu.pucsp.virtualtrainer.mapper;

import org.mapstruct.Mapper;

import br.edu.pucsp.virtualtrainer.domain.dto.LiveClassDto;
import br.edu.pucsp.virtualtrainer.domain.entity.LiveClass;

@Mapper(uses = TrainerMapper.class)
public interface LiveClassMapper {

    LiveClassDto entityToDto(LiveClass liveClass);
    // LiveClass requestToEntity(LiveClassRequest request);

}
