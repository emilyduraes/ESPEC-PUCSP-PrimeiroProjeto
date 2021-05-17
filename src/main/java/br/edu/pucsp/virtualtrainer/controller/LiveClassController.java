package br.edu.pucsp.virtualtrainer.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.pucsp.virtualtrainer.service.LiveClassService;
import br.edu.pucsp.virtualtrainer.transport.request.LiveClassRequest;
import br.edu.pucsp.virtualtrainer.transport.response.LiveClassResponse;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/live-class")
public class LiveClassController {

    private final LiveClassService liveClassService;

    public LiveClassController(LiveClassService liveClassService) {
        this.liveClassService = liveClassService;
    }

    @ApiOperation(value = "Insert a Live Class into the database")
    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createLiveClass(@RequestBody @Valid LiveClassRequest request) {
        liveClassService.createLiveClass(request);
    }

    // @ApiOperation(value = "Find a Live Class from the database")
    // @GetMapping(path = "/id/{liveClassId}")
    // public LiveClassResponse getLiveClass (@PathVariable Long liveClassId) {
    //     return new LiveClassResponse(liveClassService.findLiveClass(liveClassId));
    // } 

    @ApiOperation(value = "Delete a live class from the database")
    @DeleteMapping(path = "/{liveClassId}")
    public void deleteLiveClass(@PathVariable Long liveClassId) {
        liveClassService.deleteLiveClass(liveClassId);
    }
}
