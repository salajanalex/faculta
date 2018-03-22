package ro.salajan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.salajan.model.Participant;

public interface ParticipantRepo extends JpaRepository<Participant, Integer> {


}
