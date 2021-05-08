package br.edu.pucsp.virtualtrainer.mapper;

import org.mapstruct.Mapper;

import br.edu.pucsp.virtualtrainer.model.dto.LiveSessionDto;
import br.edu.pucsp.virtualtrainer.model.entity.LiveSession;
import br.edu.pucsp.virtualtrainer.transport.request.LiveSessionRequest;

@Mapper()
public interface LiveSessionMapper {
    LiveSessionDto entityToDto(LiveSession session);
    // LiveSession requestToEntity(LiveSessionRequest request);
}
