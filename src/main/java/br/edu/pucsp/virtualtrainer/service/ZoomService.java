package br.edu.pucsp.virtualtrainer.service;

import br.edu.pucsp.virtualtrainer.transport.request.api.ZoomMeetingRequest;
import br.edu.pucsp.virtualtrainer.transport.response.api.ZoomTokenResponse;

public interface ZoomService {


    String createMeeting(ZoomMeetingRequest request);
}
