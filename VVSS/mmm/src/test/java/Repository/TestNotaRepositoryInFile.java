package Repository;

import static org.junit.Assert.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Domain.HasID;
import Domain.Student;
import Domain.Tema;
import ValidatorsAndExceptions.ValidatorStudent;
import org.junit.Test;

import Domain.Nota;
import Repository.NotaRepositoryInFile;
import ValidatorsAndExceptions.ValidatorNota;
import javafx.util.Pair;

public class TestNotaRepositoryInFile extends TestRepositoryInFile{

	NotaRepositoryInFile el;



	public NotaRepositoryInFile fill() {
		PrintWriter pw;
		try {
			pw = new PrintWriter("src\\test\\java\\testResources\\CatalogTest.txt");
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ValidatorNota validatorNota = new ValidatorNota();
		NotaRepositoryInFile noteRepo = new NotaRepositoryInFile("src\\test\\java\\testResources\\CatalogTest.txt",
				validatorNota);
		Student a = new Student(1,"Robert",1,"robert@yahoo","Andrei");
		Tema t = new Tema(1,"tema1",3);
		Nota nota = new Nota(a,t,1,10);
		noteRepo.add(nota);
		toFindFirst=nota;
		noteRepo.createInstance("2|2|3|3");
		noteRepo.createInstance("3|3|3|3");
		size = 3;
		Student aa = new Student(4,"Sava",1,"sava@yahoo","Troanca");
		Tema tt = new Tema(4,"tema3",3);
		toAdd = new Nota(aa,tt,10,8);
		elem = noteRepo;
		elemTata = noteRepo;
		return noteRepo;
	}


	@Test
	public void testUpdate() {
		Student a = new Student(1,"Robert",1,"robert@yahoo","Andrei");
		Tema t = new Tema(1,"tema1",3);
		Nota nota = new Nota(a,t,1,10);
		nota.setValoare(9);
		//el.update(nota);
		assertEquals("9", ""+nota.getValoare());
	}

	@Test
	public void testCreateInstance() {
		NotaRepositoryInFile test = fill();
		el = fill();
		Student a = new Student(11);
		Tema t = new Tema(11);
		el.createInstance("11|11|1|9");
		Nota nota = new Nota(a,t,1,9);
		test.add(nota);
		//assertEquals(el.toString(),test.toString());

	}

	@Test
	public void testWriteInstance()//
	{
		String fileName = "src\\test\\java\\testResources\\CatalogTest.txt";
		try(BufferedWriter writer=new BufferedWriter(new FileWriter(fileName))){
			PrintWriter pw;
			try {
				pw = new PrintWriter("src\\test\\java\\testResources\\CatalogTest.txt");
				pw.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ValidatorNota validatorNota = new ValidatorNota();
			el = new NotaRepositoryInFile("src\\test\\java\\testResources\\CatalogTest.txt",
					validatorNota);
			Student a = new Student(1,"Robert",1,"robert@yahoo","Andrei");
			Tema t = new Tema(1,"tema1",3);
			Nota nota = new Nota(a,t,1,10);
			el.add(nota);
			BufferedReader reader =  new BufferedReader(new FileReader(fileName));
			String rez = reader.readLine();
			assertEquals(rez,"1|1|1|10");
		}
		catch (Exception e)
		{
			assertEquals(true,false);
		}
	}

	@Test
	@Override
	public void testDelete(){

	};

	@Test
	@Override
	public void testAddError(){

	};

	@Test
	@Override
	public void testFindOne(){

	};




	//Error!------------------------------------------------------------------------

	@Test
	public void testCreateInstanceError1()// structura stringului nu e buna
	{
		el = fill();
		try{
			el.createInstance("3|3|3|3|3");
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
			el.createInstance("3|3|s|3");
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
			Student a = new Student(1,"Robert",1,"robert@yahoo","Andrei");
			Tema t = new Tema(1,"tema1",3);
			Nota nota = new Nota(a,t,3,8);
			el.writeInstace(null, nota);
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
		ValidatorNota validator = new ValidatorNota();
		try {
			NotaRepositoryInFile nota =  fill();
			nota.setFileName(null);
			Student a = new Student(20,"Robert",1,"robert@yahoo","Andrei");
			Tema t = new Tema(20,"tema1",3);
			Nota nota2 = new Nota(a,t,3,8);
			nota.add(nota2);
			assertEquals(true,false);
		}
		catch(RepositoryException e){
			RepositoryException expect = new RepositoryException("Can't write to file\n");
			assertEquals(expect.toString(),e.toString());
		}
	}






	/*@Test
	public void testCreateInstance() {
		PrintWriter pw;
		try {
			pw = new PrintWriter("src\\test\\java\\testResources\\CatalogTest.txt");
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ValidatorNota validatorNota = new ValidatorNota();
		NotaRepositoryInFile notaRepo = new NotaRepositoryInFile("src\\test\\java\\testResources\\CatalogTest.txt",
				validatorNota);

		notaRepo.createInstance("2|1|10|3");

		List<Nota> note = new ArrayList<Nota>();

		notaRepo.getAll().forEach(nota -> {
			note.add(nota);
		});
		//assertEquals((long)10,(long) note.get(0).getValoare());
		assertEquals(new Pair<Integer,Integer>(2, 1), note.get(0).getID());
	}*/



}
