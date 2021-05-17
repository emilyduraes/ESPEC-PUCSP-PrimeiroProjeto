package br.edu.pucsp.virtualtrainer.mapper;

import org.mapstruct.Mapper;

import br.edu.pucsp.virtualtrainer.model.dto.LiveClassDto;
import br.edu.pucsp.virtualtrainer.model.entity.LiveClass;
import br.edu.pucsp.virtualtrainer.transport.request.LiveClassRequest;

@Mapper()
public interface LiveClassMapper {
    LiveClassDto entityToDto(LiveClass liveClass);
    // LiveClass requestToEntity(LiveClassRequest request);
}
