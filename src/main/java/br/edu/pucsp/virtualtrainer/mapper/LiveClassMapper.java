package br.edu.pucsp.virtualtrainer.mapper;

import br.edu.pucsp.virtualtrainer.domain.entity.Field;
import br.edu.pucsp.virtualtrainer.domain.entity.Trainer;
import br.edu.pucsp.virtualtrainer.domain.request.LiveClassRequest;
import br.edu.pucsp.virtualtrainer.domain.response.api.ZoomMetingResponse;
import org.mapstruct.Mapper;

import br.edu.pucsp.virtualtrainer.domain.dto.LiveClassDto;
import br.edu.pucsp.virtualtrainer.domain.entity.LiveClass;
import org.mapstruct.Mapping;

@Mapper(uses = TrainerMapper.class)
public interface LiveClassMapper {

    LiveClassDto entityToDto(LiveClass liveClass);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "trainer", source = "trainer")
    @Mapping(target = "field", source = "field")
    @Mapping(target = "startUrl", source = "response.start_url")
    @Mapping(target = "joinUrl", source = "response.join_url")
    @Mapping(target = "type", source = "request.type")
    LiveClass createEntity(LiveClassRequest request, Trainer trainer, Field field, ZoomMetingResponse response);

}
