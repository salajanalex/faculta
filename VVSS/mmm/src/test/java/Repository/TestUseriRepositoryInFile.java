package Repository;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.Test;

import Domain.Student;
import Domain.User;
import Repository.StudentRepositoryInFile;
import Repository.UserRepositoryInFile;
import ValidatorsAndExceptions.ValidatorStudent;
import ValidatorsAndExceptions.ValidatorUser;

public class TestUseriRepositoryInFile {

	@Test
	public void testCreateInstance() {
		PrintWriter pw;
		try {
			pw = new PrintWriter("src\\test\\java\\testResources\\UseriTest.txt");
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ValidatorUser validatorUser = new ValidatorUser();
		UserRepositoryInFile useriRepo = new UserRepositoryInFile("src\\test\\java\\testResources\\UseriTest.txt",
				validatorUser);

		useriRepo.createInstance("simonaburlacu01@gmail.com|huzW3hw+u02eGfeT+ZMWgA==|profesor");

		User user=useriRepo.findOne("simonaburlacu01@gmail.com");
		
		//assertEquals((long)10,(long) note.get(0).getValoare());
		assertEquals("simonaburlacu01@gmail.com", user.getID());
	}

}
