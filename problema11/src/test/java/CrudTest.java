import static org.junit.Assert.*;

import ro.salajan.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ro.salajan.model.Cursa;
import ro.salajan.model.Participant;
import ro.salajan.model.User;
import ro.salajan.repository.CursaRepo;
import ro.salajan.repository.ParticipantRepo;
import ro.salajan.repository.UserRepo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CrudTest {

    @Autowired
    private UserRepo repo;

    @Test
    public void testCreate() {
        User user1 = new User("sava", "passw");
        user1 = repo.save(user1);
        assertNotNull(user1.getUser());
        repo.delete(user1);
    }

    @Test
    public void testDeleteUser() {
        User user1 = new User("sava", "passw");
        user1 = repo.save(user1);
        repo.delete(user1);
        assertNull(repo.findOne(user1.getId()));

    }

    @Autowired
    private ParticipantRepo repo1;

    @Test
    public void testCreatee() {
       Participant part1 = new Participant("sava", "Honda", 150, 2);
        part1 = repo1.save(part1);
        assertNotNull(part1.getNume());

    }


    @Autowired
    private CursaRepo repo2;

    @Test
    public void testCreateCursa() {
       Cursa cursa = new Cursa("cursa", 250);
        cursa = repo2.save(cursa);
        assertNotNull(cursa.getNume());

    }


    @Test
    public void testCreateCursa2() {
        Cursa cursa = new Cursa("cursa", 4);
        cursa = repo2.save(cursa);
        Participant part3 = new Participant("alex","Porshe",150,3);
        part3 = repo1.save(part3);
        cursa.addParticipant(part3);
        cursa = repo2.save(cursa);
        assertNotNull(repo2.findOne(part3.getId()));

    }






}
