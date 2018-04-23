package testRepository;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Domain.Student;
import Domain.Tema;
import Repository.RepositoryException;
import Repository.StudentRepositoryInFile;
import Repository.TemaRepositoryInFile;
import ValidatorsAndExceptions.ValidatorStudent;
import ValidatorsAndExceptions.ValidatorTema;

public class TestStudentiRepositoryInFile {

	@Test
	public void testCreateInstance() {

		StudentRepositoryInFile studentiRepo=cleanAndValidate();
		studentiRepo.createInstance("2|Roby|1|Roby@yahoo|Serban");

		Student student=studentiRepo.findOne(2);

		//assertEquals((long)10,(long) note.get(0).getValoare());
		assertEquals((long)2, (long)student.getID());
	}
	@Test
	public void testCreateInstanceErr() {

		StudentRepositoryInFile studentiRepo=cleanAndValidate();
		studentiRepo.createInstance("2|Roby|eeee|Roby@yahoo|Serban");
		try {
			Student student = studentiRepo.findOne(2);
			assertEquals(true, false);
		}
		catch(RepositoryException e){
			System.out.print(e);
			assertEquals(new RepositoryException("ID "+2+" nu exista").toString(),e.toString());
		}
	}
	@Test
	public void testCreateInstanceMultiple() {

		StudentRepositoryInFile studentiRepo=cleanAndValidate();
		studentiRepo.createInstance("2|Roby|1|Roby@yahoo|Serban|112");
		try {
			Student student = studentiRepo.findOne(2);
			assertEquals(true, false);
		}
		catch(RepositoryException e){
			System.out.print(e);
			assertEquals(new RepositoryException("ID "+2+" nu exista").toString(),e.toString());
		}
	}

	//@Test
	//public void testWrite() {

	//	StudentRepositoryInFile studentiRepo=cleanAndValidate();
	//	studentiRepo.writeInstace(null,null);

		//assertEquals((long)10,(long) note.get(0).getValoare());
	//	assertEquals(true, true);
	//}


	@Test
	public void testDelete() {
		StudentRepositoryInFile studentiRepo=cleanAndValidate();
		studentiRepo.createInstance("2|Roby|1|Roby@yahoo|Serban");

		studentiRepo.delete(2);

		assertEquals(0, studentiRepo.size());
	}

	@Test
	public void testUpdate() {
		StudentRepositoryInFile studentiRepo=cleanAndValidate();
		studentiRepo.createInstance("2|Roby|1|Roby@yahoo|Serban");

		Student student= studentiRepo.findOne(2);
		student.setEmail("Roby99@yahoo");

		studentiRepo.update(student);;

		assertEquals("Roby99@yahoo", studentiRepo.findOne(2).getEmail());
	}

	@Test(expected=RepositoryException.class)
	public void testAddException() {
		StudentRepositoryInFile studentiRepo=cleanAndValidate();
		studentiRepo.createInstance("2|Roby|1|Roby@yahoo|Serban");

		studentiRepo.createInstance("2|Roby|1|Roby@yahoo|Serban");
	}
	
	@Test(expected=RepositoryException.class)
	public void testDeleteException() {
		StudentRepositoryInFile studentiRepo=cleanAndValidate();
		studentiRepo.delete(2);
	}
	
	@Test(expected=RepositoryException.class)
	public void testFindOneException() {
		StudentRepositoryInFile studentiRepo=cleanAndValidate();
		studentiRepo.findOne(2);
	}
	
	@Test(expected=RepositoryException.class)
	public void testUpdateException() {
		StudentRepositoryInFile studentiRepo=cleanAndValidate();
		Student student= new Student(2,"Alex",3,"alex@yahoo","Herban");
		studentiRepo.update(student);
	}

	StudentRepositoryInFile cleanAndValidate(){
		PrintWriter pw;
		try {
			pw = new PrintWriter("src\\test\\java\\testResources\\StudentiTest.txt");
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ValidatorStudent validatorStudent = new ValidatorStudent();
		StudentRepositoryInFile studentiRepo = new StudentRepositoryInFile("src\\test\\java\\testResources\\StudentiTest.txt",
				validatorStudent);
		return studentiRepo;
	}

}
