package br.edu.pucsp.virtualtrainer.service;

import br.edu.pucsp.virtualtrainer.domain.request.api.ZoomMeetingRequest;
import br.edu.pucsp.virtualtrainer.domain.response.api.ZoomMetingResponse;

public interface ZoomApiService {

    ZoomMetingResponse createMeeting(ZoomMeetingRequest request);
}
