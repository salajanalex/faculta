package testRepository;

import static org.junit.Assert.*;

import org.junit.Test;

import Domain.Student;
import Repository.StudentRepositoryInMemory;
import ValidatorsAndExceptions.ValidatorStudent;

public class TestStudentRepositoryInMemory {

	@Test
	public void testConstructor() {
		ValidatorStudent validatorStudent = new ValidatorStudent();
		StudentRepositoryInMemory studentRepo=new StudentRepositoryInMemory(validatorStudent);
		
		studentRepo.add(new Student(2,"Alex",3,"Alex@yahoo","Herban"));
		
		assertEquals("Alex", studentRepo.findOne(2).getNume());
	}

}
