package testRepository;

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

		UserRepositoryInFile useriRepo =cleanAndValidate();
		useriRepo.createInstance("alexsalajan@gmail.com|1234567|profesor");

		User user=useriRepo.findOne("alexsalajan@gmail.com");
		
		//assertEquals((long)10,(long) note.get(0).getValoare());
		assertEquals("alexsalajan@gmail.com", user.getID());
	}
	UserRepositoryInFile cleanAndValidate(){

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

		return useriRepo;
	}
}
