package ro.salajan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.salajan.model.Participant;
import ro.salajan.repository.ParticipantRepo;
import ro.salajan.service.ParticipantService;

import java.util.List;

@Service
public class ParticipantServiceImplementation implements ParticipantService {

    @Autowired
    private ParticipantRepo participantRepo;

    @Override
    public List<Participant> findParticipantByEchipa(String echipa) {
        return participantRepo.findByEchipa(echipa) ;
    }

    @Override
    public void addParticipant(Participant participant) {
        participantRepo.save(participant);
    }

    @Override
    public List<Participant> getAllParticipanti() {
        return participantRepo.findAll();
    }
}
