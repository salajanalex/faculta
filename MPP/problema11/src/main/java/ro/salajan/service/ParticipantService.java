package ro.salajan.service;

import ro.salajan.model.Participant;

import java.util.List;

public interface ParticipantService {
    
    List<Participant> findParticipantByEchipa(String echipa);
    void addParticipant(Participant participant);
    List<Participant> getAllParticipanti();
}
