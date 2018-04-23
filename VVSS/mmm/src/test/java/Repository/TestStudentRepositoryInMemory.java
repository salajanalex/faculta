package Repository;

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
		
		studentRepo.add(new Student(2,"Andrei",3,"andrei@yahoo","Serban"));
		
		assertEquals("Andrei", studentRepo.findOne(2).getNume());
	}

}
