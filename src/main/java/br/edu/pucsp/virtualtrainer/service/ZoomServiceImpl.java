package br.edu.pucsp.virtualtrainer.service;

import br.edu.pucsp.virtualtrainer.service.api.ZoomApiClient;
import br.edu.pucsp.virtualtrainer.domain.request.api.ZoomMeetingRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

@Service
public class ZoomServiceImpl implements ZoomService{

    private static final Logger log = LoggerFactory.getLogger(ZoomServiceImpl.class);


    public static final String AUTHORIZATION = "Authorization";

    private final ZoomApiClient zoomApiClient;
    private final ZoomAuthService zoomAuthService;

    public ZoomServiceImpl(ZoomApiClient zoomApiClient, ZoomAuthService zoomAuthService) {
        this.zoomApiClient = zoomApiClient;
        this.zoomAuthService = zoomAuthService;
    }

    @Override
    public String createMeeting(ZoomMeetingRequest request) {

        Long clientId = 1L;//TODO pegar isso de algum lugar
        String token = zoomAuthService.getToken(clientId);

        var header = new HttpHeaders();
        header.add(AUTHORIZATION, "Bearer " + token);
        header.setContentType(MediaType.APPLICATION_JSON);

        String response = null;
        try {
            response = zoomApiClient.createMeeting(header, request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.error("Response {}", response);
        return response;
    }

}