package br.edu.pucsp.virtualtrainer.service;

import java.util.List;

import br.edu.pucsp.virtualtrainer.model.dto.LiveClassDto;
import br.edu.pucsp.virtualtrainer.transport.request.LiveClassRequest;

public interface LiveClassService {

    void createLiveClass(LiveClassRequest request);
    LiveClassDto findLiveClass(Long id);
    List<LiveClassDto> findLiveClasses(String title);
    List<LiveClassDto> findAllFutureLiveClasses();
    void deleteLiveClass(Long id);
    void updateLiveClass(LiveClassRequest request);
    void addStudentToLiveClass (Long id, Long studentId);

}
