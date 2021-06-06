package br.edu.pucsp.virtualtrainer.service.api;

import br.edu.pucsp.virtualtrainer.domain.request.api.ZoomMeetingRequest;
import br.edu.pucsp.virtualtrainer.domain.response.api.ZoomMetingResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "ZoomApiClient", url = "https://api.zoom.us/v2")
public interface ZoomApiClient {

    @PostMapping(path = "/users/me/meetings")
    ZoomMetingResponse createMeeting(@RequestHeader HttpHeaders header,
                                     @RequestBody ZoomMeetingRequest request);
}
