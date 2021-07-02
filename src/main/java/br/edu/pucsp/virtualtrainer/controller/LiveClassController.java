package br.edu.pucsp.virtualtrainer.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import br.edu.pucsp.virtualtrainer.domain.request.AddStudentRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.pucsp.virtualtrainer.service.LiveClassService;
import br.edu.pucsp.virtualtrainer.domain.request.LiveClassRequest;
import br.edu.pucsp.virtualtrainer.domain.response.LiveClassListResponse;
import br.edu.pucsp.virtualtrainer.domain.response.LiveClassResponse;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://34.68.231.180")
@RestController
@RequestMapping("/live-class")
public class LiveClassController {

    private final LiveClassService liveClassService;

    public LiveClassController(LiveClassService liveClassService) {
        this.liveClassService = liveClassService;
    }

    @ApiOperation(value = "Insert a Live Class into the database")
    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('TRAINER')")
    @ResponseStatus(HttpStatus.CREATED)
    public void createLiveClass(@RequestBody @Valid LiveClassRequest request) {
        liveClassService.createLiveClass(request);
    }

    @ApiOperation(value = "Find a Live Class from the database by id")
    @GetMapping(path = "/id/{liveClassId}")
    public LiveClassResponse getLiveClass (@PathVariable Long liveClassId) {
        return new LiveClassResponse(liveClassService.findLiveClass(liveClassId));
    } 

    @ApiOperation(value = "Find a Live Class from the database by title (only returns classes from the future)")
    @GetMapping(path = "/title/{liveClassTitle}")
    public LiveClassListResponse getLiveClasses (@PathVariable String liveClassTitle) {
        return new LiveClassListResponse(liveClassService.findLiveClasses(liveClassTitle));
    } 

    @ApiOperation(value = "Recover all Live Classes from the database happening in the future")
    @GetMapping
    public LiveClassListResponse getAllFutureLiveClasses() {
        return new LiveClassListResponse(liveClassService.findAllFutureLiveClasses());
    } 

    @ApiOperation(value = "Updates a live class title in the database")
    @PatchMapping
    @PreAuthorize("hasRole('TRAINER')")
    public void updateLiveClass(@RequestBody @Valid LiveClassRequest request) {
        liveClassService.updateLiveClass(request);
    }

    @ApiOperation(value = "Delete a live class from the database")
    @DeleteMapping(path = "/{liveClassId}")
    @PreAuthorize("hasRole('TRAINER')")
    public void deleteLiveClass(@PathVariable Long liveClassId) {
        liveClassService.deleteLiveClass(liveClassId);
    }

    @ApiOperation(value = "Add a student to an existing class")
    @PostMapping(path = "/addStudent")
    @PreAuthorize("hasRole('TRAINER')")
    public void addStudent(@RequestBody AddStudentRequest request){
        liveClassService.addStudentToLiveClass(request);
    }
}
