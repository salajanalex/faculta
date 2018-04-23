package testRepository;

import static org.junit.Assert.*;

import org.junit.Test;

import Domain.Student;
import Domain.Tema;
import Repository.StudentRepositoryInMemory;
import Repository.TemaRepositoryInMemory;
import ValidatorsAndExceptions.ValidatorStudent;
import ValidatorsAndExceptions.ValidatorTema;

public class TestTemaRepositoryInMemory {

	@Test
	public void testConstructor() {
		ValidatorTema validatorTema = new ValidatorTema();
		TemaRepositoryInMemory temaRepo=new TemaRepositoryInMemory(validatorTema);
		
		temaRepo.add(new Tema(1, "Tema1", 3));
		
		assertEquals("Tema1", temaRepo.findOne(1).getDescriere());
	}

}
