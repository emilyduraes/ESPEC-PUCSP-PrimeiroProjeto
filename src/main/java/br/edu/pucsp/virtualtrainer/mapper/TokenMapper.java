package br.edu.pucsp.virtualtrainer.mapper;

import br.edu.pucsp.virtualtrainer.domain.entity.ZoomToken;
import br.edu.pucsp.virtualtrainer.domain.response.api.ZoomTokenResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface TokenMapper {

    @Mapping(source = "expiresIn", target = "expirationDate")
    ZoomToken responseToEntity(ZoomTokenResponse response);

    @Mapping(source = "expiresIn", target = "expirationDate")
    ZoomToken updateEntity(ZoomTokenResponse response, @MappingTarget ZoomToken zoomToken);

}
