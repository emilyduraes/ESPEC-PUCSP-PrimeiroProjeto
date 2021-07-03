package br.edu.pucsp.virtualtrainer.controller;

import br.edu.pucsp.virtualtrainer.domain.response.api.ZoomMetingResponse;
import br.edu.pucsp.virtualtrainer.service.ZoomApiService;
import br.edu.pucsp.virtualtrainer.domain.request.api.ZoomMeetingRequest;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://34.68.231.180")
@RestController()
@RequestMapping("/zoom/api")
public class ZoomApiController {

    private final ZoomApiService zoomApiService;

    public ZoomApiController(ZoomApiService zoomApiService){
        this.zoomApiService = zoomApiService;
    }

    @PostMapping(path = "/meeting")
    public ZoomMetingResponse scheduleMeeting(@RequestBody ZoomMeetingRequest request){
        return zoomApiService.createMeeting(request);
    }

    @GetMapping(path = "/meeting")
    public void listUserMeetings(String userId){
        zoomApiService.listMeetings(userId);
    }

}
