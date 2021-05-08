package br.edu.pucsp.virtualtrainer.service;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import br.edu.pucsp.virtualtrainer.exception.DataNotFoundException;
import br.edu.pucsp.virtualtrainer.mapper.LiveSessionMapper;
import br.edu.pucsp.virtualtrainer.model.dto.LiveSessionDto;
import br.edu.pucsp.virtualtrainer.model.entity.Field;
import br.edu.pucsp.virtualtrainer.model.entity.LiveSession;
import br.edu.pucsp.virtualtrainer.model.entity.Trainer;
import br.edu.pucsp.virtualtrainer.repository.FieldRepository;
import br.edu.pucsp.virtualtrainer.repository.LiveSessionRepository;
import br.edu.pucsp.virtualtrainer.repository.TrainerRepository;
import br.edu.pucsp.virtualtrainer.transport.request.LiveSessionRequest;

@Service
public class LiveSessionServiceImpl implements LiveSessionService {

    // private static final LiveSessionMapper MAPPER = Mappers.getMapper(LiveSessionMapper.class);

    LiveSessionRepository repository;

    TrainerRepository trainerRepository;

    FieldRepository fieldRepository;

    public LiveSessionServiceImpl(LiveSessionRepository repository, TrainerRepository trainerRepository,
            FieldRepository fieldRepository) {
        this.repository = repository;
        this.trainerRepository = trainerRepository;
        this.fieldRepository = fieldRepository;
    }

    @Override
    public void createLiveSession(LiveSessionRequest request) {
        Trainer trainer = trainerRepository.findById(request.getTrainer()).orElseThrow(() -> new DataNotFoundException(request.getTrainer()));
        Field field = fieldRepository.findById(request.getField()).orElseThrow(() -> new DataNotFoundException(request.getField()));

        // LiveSession liveSession = MAPPER.requestToEntity(request);
        LiveSession liveSession = new LiveSession();

        liveSession.setField(field);
        liveSession.setTrainer(trainer);
        liveSession.setDate(request.getDate());
        liveSession.setLength(request.getLength());
        liveSession.setTitle(request.getTitle());

        repository.save(liveSession);
    }

    @Override
    public LiveSessionDto findLiveSession(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<LiveSessionDto> findLiveSessions(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteLiveSession(Long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateLiveSession(LiveSessionRequest request, Long id) {
        // TODO Auto-generated method stub

    }

}
