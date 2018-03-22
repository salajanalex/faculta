package ro.salajan.repository;

import ro.salajan.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SudentRepo extends JpaRepository<Student, Integer> {
}
