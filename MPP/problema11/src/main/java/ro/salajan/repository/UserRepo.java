package ro.salajan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.salajan.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

    public User findByUsername(String username);

}
