//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import ro.salajan.Application;
//import ro.salajan.model.User;
//import ro.salajan.repository.UserRepo;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
//public class TestUser {
//
//    @Autowired
//    private UserRepo userRepo;
//
//    @Test
//    public void testCreate() {
//        User user1 = new User("sava", "passw");
//        user1 = userRepo.save(user1);
//        assertNotNull(user1.getUser());
//        userRepo.delete(user1);
//    }
//
//    @Test
//    public void testDeleteUser() {
//        User user1 = new User("sava", "passw");
//        user1 = repo.save(user1);
//        repo.delete(user1);
//        assertNull(repo.findOne(user1.getId()));
//
//    }