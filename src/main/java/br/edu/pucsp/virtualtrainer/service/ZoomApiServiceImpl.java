package br.edu.pucsp.virtualtrainer.service;

import br.edu.pucsp.virtualtrainer.domain.response.api.ZoomMetingResponse;
import br.edu.pucsp.virtualtrainer.service.api.ZoomApiClient;
import br.edu.pucsp.virtualtrainer.domain.request.api.ZoomMeetingRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

@Service
public class ZoomApiServiceImpl implements ZoomApiService {

    public static final String AUTHORIZATION = "Authorization";

    private final ZoomApiClient zoomApiClient;
    private final ZoomAuthService zoomAuthService;

    public ZoomApiServiceImpl(ZoomApiClient zoomApiClient, ZoomAuthService zoomAuthService) {
        this.zoomApiClient = zoomApiClient;
        this.zoomAuthService = zoomAuthService;
    }

    @Override
    public ZoomMetingResponse createMeeting(ZoomMeetingRequest request) {

        String token = zoomAuthService.getToken(request.getTrainerId());

        var header = new HttpHeaders();
        header.add(AUTHORIZATION, "Bearer " + token);
        header.setContentType(MediaType.APPLICATION_JSON);

        ZoomMetingResponse response = null;
        try {
            response = zoomApiClient.createMeeting(header, request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

}