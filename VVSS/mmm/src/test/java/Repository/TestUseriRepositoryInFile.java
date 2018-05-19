package Repository;

import static org.junit.Assert.*;

import java.io.*;

import Domain.HasID;
import org.junit.Test;

import Domain.Student;
import Domain.User;
import Repository.StudentRepositoryInFile;
import Repository.UserRepositoryInFile;
import ValidatorsAndExceptions.ValidatorStudent;
import ValidatorsAndExceptions.ValidatorUser;

public class TestUseriRepositoryInFile extends TestRepositoryInFile{


	UserRepositoryInFile el;




	public UserRepositoryInFile fill(){
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


		useriRepo.add( new User("salajanalex@gmail.com","password","profesor"));
		toFindFirst = useriRepo.findOne("salajanalex@gmail.com");
		useriRepo.createInstance("lupoaierobert@gmail.com|password|profesor");
		useriRepo.createInstance("savacristin@gmail.com|password|profesor");




		size = 3;
		toAdd = new User("pirpidelsebastian@gmail.com","password","profesor");
		elem = useriRepo;
		elemTata = useriRepo;
		return useriRepo;
	}



	@Test
	public void testUpdate() {
		el = fill();
		User user= el.findOne("salajanalex@gmail.com");
		user.setRol("student");
		el.update(user);
		assertEquals("student", el.findOne("salajanalex@gmail.com").getRol());
	}

	@Test
	public void testCreateInstance() {
		el = fill();
		el.createInstance("savarina@gmail.com|password|profesor");
		HasID student=el.findOne("savarina@gmail.com");
		assertEquals("savarina@gmail.com",el.findOne("savarina@gmail.com").getEmail());
	}


	@Test
	public void testWriteInstance()//
	{
		el= fill();
		String fileName = "src\\test\\java\\testResources\\UseriTest.txt";
		try(BufferedWriter writer=new BufferedWriter(new FileWriter(fileName))){
			User user = new User("robertinio@gmail.com","password","profesor");
			el.delete("salajanalex@gmail.com");
			el.delete("lupoaierobert@gmail.com");
			el.delete("savacristin@gmail.com");
			el.add(user);
			BufferedReader reader =  new BufferedReader(new FileReader(fileName));
			String rez = reader.readLine();
			assertEquals(rez,"robertinio@gmail.com|password|profesor");
		}
		catch (Exception e)
		{
			assertEquals(true,false);
		}
	}

	@Test
	public void testDelete()
	{
		fill();
		elem.delete("salajanalex@gmail.com");
		assertEquals(size-1, elem.size());
	}


	@Test
	public void testFindOne(){
		//are nevoie de toFindFirst = elementul cu id =1
		el = fill();
		assertEquals(toFindFirst.toString(),(el.findOne("salajanalex@gmail.com")).toString());
	}



	//Error!------------------------------------------------------------------------



	@Test
	public void testCreateInstanceError1()// structura stringului nu e buna
	{
		el = fill();
		try{
			el.createInstance("robertinioo@gmail.com|password|profesor|salut");
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
			el.createInstance("robertinio@gmail.com|passw|profesor");
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
			User user = new User("robertinioo@gmail.com","password","profesor");
			el.writeInstace(null, user);
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
			UserRepositoryInFile userRepo =  fill();
			userRepo.setFileName(null);
			User user = new User("robertinio@gmail.com","password","profesor");
			userRepo.add(user);
			assertEquals(true,false);
		}
		catch(RepositoryException e){
			RepositoryException expect = new RepositoryException("Can't write to file\n");
			assertEquals(expect.toString(),e.toString());
		}

	}

	@Test
	public void testAddError()
	{
		fill();
		try{
			elem.add(toFindFirst);
			assertEquals(true,false);
		}
		catch(RepositoryException e)
		{
			RepositoryException expect = new RepositoryException("Exista deja un element cu ID salajanalex@gmail.com");
			assertEquals(expect.toString(),e.toString());
		}
	}



}
