package br.edu.pucsp.virtualtrainer.controller;

import br.edu.pucsp.virtualtrainer.service.TrainerService;
import br.edu.pucsp.virtualtrainer.domain.request.TrainerFieldRequest;
import br.edu.pucsp.virtualtrainer.domain.request.TrainerRequest;
import br.edu.pucsp.virtualtrainer.domain.response.TrainerListResponse;
import br.edu.pucsp.virtualtrainer.domain.response.TrainerResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "http://35.184.242.241:4200")
@RestController()
@RequestMapping("/trainer")
public class TrainerController {

    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService){
        this.trainerService = trainerService;
    }

    @ApiOperation(value = "Insert a trainer into the database")
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTrainer(
            @RequestBody @Valid TrainerRequest request){
        trainerService.createTrainer(request);
    }

    @ApiOperation(value = "Recover a trainer by name")
    @GetMapping(path = "/name/{trainerName}")
    public TrainerListResponse getTrainers(
            @PathVariable String trainerName){
        return new TrainerListResponse(trainerService.findTrainers(trainerName));
    }

    @ApiOperation(value = "Recover a trainer by id")
    @GetMapping(path = "/id/{trainerId}")
    public TrainerResponse getTrainer(
            @PathVariable Long trainerId){
        return new TrainerResponse(trainerService.findTrainer(trainerId));
    }

    @ApiOperation(value = "Recover all available trainers")
    @GetMapping
    public TrainerListResponse getAllTrainers(){
        return new TrainerListResponse(trainerService.findAllTrainers());
    }

    @ApiOperation(value = "Update a trainer's info")
    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void updateTrainer(
            @RequestBody @Valid TrainerRequest request){
        trainerService.updateTrainer(request);
    }

    @ApiOperation(value = "Delete a trainer")
    @DeleteMapping(path = "/{trainerId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteTrainer(
            @PathVariable Long trainerId){
        trainerService.deleteTrainer(trainerId);
    }

    @ApiOperation(value = "Set the trainer's field")
    @PostMapping(path = "/setField", produces = APPLICATION_JSON_VALUE, consumes =APPLICATION_JSON_VALUE )
    public void addField(
            @RequestBody TrainerFieldRequest trainerFieldRequest){
        trainerService.addFields(trainerFieldRequest);
    }
}
