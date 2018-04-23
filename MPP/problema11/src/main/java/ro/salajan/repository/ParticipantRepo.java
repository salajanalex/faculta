package ro.salajan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.salajan.model.Participant;

import java.util.List;

public interface ParticipantRepo extends JpaRepository<Participant, Integer> {
    public List<Participant> findByEchipa(String echipa);

}
