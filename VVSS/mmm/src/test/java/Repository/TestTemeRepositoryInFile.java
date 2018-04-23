package Repository;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Domain.Nota;
import Domain.Tema;
import Repository.NotaRepositoryInFile;
import Repository.TemaRepositoryInFile;
import ValidatorsAndExceptions.ValidatorNota;
import ValidatorsAndExceptions.ValidatorTema;
import javafx.util.Pair;

public class TestTemeRepositoryInFile {

	@Test
	public void testCreateInstance() {
		PrintWriter pw;
		try {
			pw = new PrintWriter("src\\test\\java\\testResources\\TemeTest.txt");
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ValidatorTema validatorTema = new ValidatorTema();
		TemaRepositoryInFile temeRepo = new TemaRepositoryInFile("src\\test\\java\\testResources\\TemeTest.txt",
				validatorTema);

		temeRepo.createInstance("2|Descriere|3");

		Tema tema=temeRepo.findOne(2);
		
		//assertEquals((long)10,(long) note.get(0).getValoare());
		assertEquals((long)2, (long)tema.getID());
	}

}
