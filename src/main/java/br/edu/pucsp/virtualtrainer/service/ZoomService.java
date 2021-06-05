package br.edu.pucsp.virtualtrainer.service;

import br.edu.pucsp.virtualtrainer.domain.request.api.ZoomMeetingRequest;

public interface ZoomService {

    String createMeeting(ZoomMeetingRequest request);
}
