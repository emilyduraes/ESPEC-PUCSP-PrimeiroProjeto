package br.edu.pucsp.virtualtrainer.domain.response;

import br.edu.pucsp.virtualtrainer.domain.dto.LiveClassDto;

public class LiveClassResponse {
    
    private LiveClassDto liveClassDto;

    public LiveClassResponse(LiveClassDto liveClassDto) {
        this.liveClassDto = liveClassDto;
    }

    public LiveClassDto getLiveClass() {
        return liveClassDto;
    }

    public void setLiveClass(LiveClassDto liveClassDto) {
        this.liveClassDto = liveClassDto;
    }
}
