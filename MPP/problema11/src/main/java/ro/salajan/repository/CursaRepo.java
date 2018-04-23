package ro.salajan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.salajan.model.Cursa;

import java.util.List;

public interface CursaRepo extends JpaRepository<Cursa, Integer> {
    public Cursa findById(int id);

}