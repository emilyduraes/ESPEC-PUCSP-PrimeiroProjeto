package br.edu.pucsp.virtualtrainer.transport.response;

import br.edu.pucsp.virtualtrainer.model.dto.LiveClassDto;

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
