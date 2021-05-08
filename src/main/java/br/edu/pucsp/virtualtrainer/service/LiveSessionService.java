package br.edu.pucsp.virtualtrainer.service;

import java.util.List;

import br.edu.pucsp.virtualtrainer.model.dto.LiveSessionDto;
import br.edu.pucsp.virtualtrainer.transport.request.LiveSessionRequest;

public interface LiveSessionService {

    void createLiveSession(LiveSessionRequest request);
    LiveSessionDto findLiveSession(Long id);
    List<LiveSessionDto> findLiveSessions(String name);
    void deleteLiveSession(Long id);
    void updateLiveSession(LiveSessionRequest request, Long id);

}
