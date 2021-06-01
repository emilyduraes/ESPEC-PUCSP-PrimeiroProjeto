package br.edu.pucsp.virtualtrainer.controller;

import br.edu.pucsp.virtualtrainer.service.ZoomService;
import br.edu.pucsp.virtualtrainer.transport.request.api.ZoomMeetingRequest;
import br.edu.pucsp.virtualtrainer.transport.response.api.ZoomTokenResponse;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/zoom")
public class ZoomController {

    private final ZoomService zoomService;

    public ZoomController(ZoomService zoomService){
        this.zoomService = zoomService;
    }

    @GetMapping(path = "/auth")
    public void getAuth(String clientId){
        zoomService.requestAuthorization(clientId);
    }

    @GetMapping(path = "/auth/callback")
    public ZoomTokenResponse receiveAuth(@RequestParam("code") String code,
                                         @RequestParam("state") String userId){
        return zoomService.requestToken(code, userId);
    }

    @PostMapping(path = "/auth/refresh")
    public ZoomTokenResponse refresh(@RequestParam("refreshToken") String refreshToken,
                                     @RequestParam("state") String userId){
        return zoomService.refreshToken(refreshToken, userId);
    }

    @PostMapping(path = "/call/meeting")
    public String scheduleMeeting(@RequestParam ZoomMeetingRequest request){
        return zoomService.createMeeting(request);
    }

}
