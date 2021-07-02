package br.edu.pucsp.virtualtrainer.mapper;

import br.edu.pucsp.virtualtrainer.domain.dto.AuthUserDto;
import br.edu.pucsp.virtualtrainer.domain.entity.AuthUser;
import br.edu.pucsp.virtualtrainer.domain.request.AuthUserRequest;
import org.mapstruct.Mapper;

@Mapper
public interface AuthUserMapper {
    AuthUser dtoToEntity(AuthUserDto authUserDto);
    AuthUserDto entityToDto(AuthUser authUser);
    AuthUser requestToEntity(AuthUserRequest request);
}