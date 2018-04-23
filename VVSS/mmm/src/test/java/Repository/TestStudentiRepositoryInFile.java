package Repository;

import static org.junit.Assert.*;

import java.io.*;

import Domain.HasID;
import org.junit.Test;

import Domain.Student;
import ValidatorsAndExceptions.ValidatorStudent;

public class TestStudentiRepositoryInFile extends TestRepositoryInFile {

	StudentRepositoryInFile el;


	public StudentRepositoryInFile fill(){
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

		toFindFirst = new Student(1,"Robert",1,"robert@yahoo","Andrei");
		studentiRepo.createInstance("1|Robert|1|robert@yahoo|Andrei");
		studentiRepo.createInstance("2|Roby|1|roby@yahoo|Andrei");
		studentiRepo.createInstance("3|Andrei|1|andrei@yahoo|Serban");
		size = 3;
		toAdd = new Student(4,"Roby",721,"roby@yahoo.com","Serban");
		elem = studentiRepo;
		elemTata = studentiRepo;
		return studentiRepo;
	}

	@Test
	public void testUpdate() {
		el = fill();
		Student student= el.findOne(2);
		student.setEmail("robyRoberto@yahoo.com");
		el.update(student);;
		assertEquals("robyRoberto@yahoo.com", el.findOne(2).getEmail());
	}

	@Test
	public void testCreateInstance() {
		el = fill();
		el.createInstance("112|Andrei|1|andrei@yahoo|Serban");
		HasID student=el.findOne(112);
		assertEquals((Integer)112, (Integer)student.getID());
	}

	@Test
	public void testWriteInstance()//
	{
		el= fill();
		String fileName = "src\\test\\java\\testResources\\StudentiTest.txt";
		try(BufferedWriter writer=new BufferedWriter(new FileWriter(fileName))){
			Student student = new Student(2, "Andrei", 3, "andrei@yahoo", "Serban");
			el.delete(1);
			el.delete(2);
			el.delete(3);
			el.add(student);
			BufferedReader reader =  new BufferedReader(new FileReader(fileName));
			String rez = reader.readLine();
			assertEquals(rez,"2|Andrei|3|andrei@yahoo|Serban");
		}
		catch (Exception e)
		{
			assertEquals(true,false);
		}
	}

	//Error!------------------------------------------------------------------------

	@Test
	public void testCreateInstanceError1()// structura stringului nu e buna
	{
		el = fill();
		try{
			el.createInstance("112|Andrei|1|andrei@yahoo|Serban|2");
			assertEquals(true,false);
		}
		catch (RepositoryException e)
		{
			RepositoryException expected = new RepositoryException("Input line does not match!");
			assertEquals(expected.toString(),e.toString());
		}

	}

	@Test
	public void testCreateInstanceError2()  //
	{
		el = fill();
		try{
			el.createInstance("112|Andrei|eee|andrei@yahoo|2");
			assertEquals(true,false);
		}
		catch (RepositoryException e)
		{
			RepositoryException expected = new RepositoryException("Create instance Error!");
			assertEquals(expected.toString(),e.toString());
		}
	}

	@Test
	public void testWriteInstanceError()
	{
		el= fill();
			try {
				Student student = new Student(2, "Andrei", 3, "andrei@yahoo", "Serban");
				el.writeInstace(null, student);
				assertEquals(true,false);
			}
			catch (RepositoryException e)
			{
				RepositoryException expected = new RepositoryException();
				expected = new RepositoryException("WriteInstance Error!");
				assertEquals(expected.toString(),e.toString());
			}
	}

	@Test
	public void testWriteToFileError()
	{
		ValidatorStudent validator = new ValidatorStudent();
		try {
			StudentRepositoryInFile stud =  fill();
			stud.setFileName(null);
			Student stude = new Student(4,"Roby",721,"roby@yahoo.com","Serban");
			stud.add(stude);
			assertEquals(true,false);
		}
		catch(RepositoryException e){
			RepositoryException expect = new RepositoryException("Can't write to file\n");
			assertEquals(expect.toString(),e.toString());
		}

	}





}
