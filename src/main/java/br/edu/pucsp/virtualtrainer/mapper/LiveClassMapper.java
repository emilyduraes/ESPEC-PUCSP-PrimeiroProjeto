package br.edu.pucsp.virtualtrainer.mapper;

import br.edu.pucsp.virtualtrainer.domain.entity.*;
import br.edu.pucsp.virtualtrainer.domain.request.LiveClassRequest;
import br.edu.pucsp.virtualtrainer.domain.response.api.ZoomMetingResponse;
import org.mapstruct.Mapper;

import br.edu.pucsp.virtualtrainer.domain.dto.LiveClassDto;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(uses = {TrainerMapper.class, StudentMapper.class})
public abstract class LiveClassMapper {

    @Mapping(target = "students", source = "liveClass.students", qualifiedByName = "listConverter")
    public abstract LiveClassDto detailedClassData(LiveClass liveClass);

    @Mapping(target = "students", source = "liveClass.students", qualifiedByName = "listConverter")
    public abstract LiveClassDto entityToDto(LiveClass liveClass);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "trainer", source = "trainer")
    @Mapping(target = "field", source = "field")
    @Mapping(target = "startUrl", source = "response.startUrl")
    @Mapping(target = "joinUrl", source = "response.joinUrl")
    @Mapping(target = "type", source = "request.type")
    public abstract LiveClass createEntity(LiveClassRequest request, Trainer trainer, Field field, ZoomMetingResponse response);

    @Named("listConverter")
    public List<Student> getStudentsList(Set<LiveClassStudents> students){
        return students
                .stream()
                .map(LiveClassStudents::getStudentId)
                .collect(Collectors.toList());
    }

}
