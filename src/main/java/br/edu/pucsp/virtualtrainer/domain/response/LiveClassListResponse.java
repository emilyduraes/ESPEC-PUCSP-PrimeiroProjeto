package br.edu.pucsp.virtualtrainer.domain.response;

import java.util.List;

import br.edu.pucsp.virtualtrainer.domain.dto.LiveClassDto;

public class LiveClassListResponse {
    
    private List<LiveClassDto> liveClasses;

    public LiveClassListResponse(List<LiveClassDto> liveClasses){
        this.setLiveClasses(liveClasses);
    }

    public List<LiveClassDto> getLiveClasses() {
        return liveClasses;
    }

    public void setLiveClasses(List<LiveClassDto> liveClasses) {
        this.liveClasses = liveClasses;
    }
}
