import Domain.Nota;
import Repository.NotaRepositoryInFile;
import ValidatorsAndExceptions.ValidatorNota;
import javafx.util.Pair;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestNotaRepositoryInFile {

    @Test
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
    }

}