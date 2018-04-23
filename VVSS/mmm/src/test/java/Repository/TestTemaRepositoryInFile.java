package Repository;

import Domain.HasID;
import Domain.Nota;
import Domain.Student;
import Domain.Tema;
import ValidatorsAndExceptions.ValidatorStudent;
import ValidatorsAndExceptions.ValidatorTema;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class TestTemaRepositoryInFile extends TestRepositoryInFile {

    TemaRepositoryInFile el;

    public TemaRepositoryInFile fill(){
        PrintWriter pw;
        try {
            pw = new PrintWriter("src\\test\\java\\testResources\\TemeTest.txt");
            pw.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ValidatorTema validatorTema = new ValidatorTema();
        TemaRepositoryInFile temaRepo = new TemaRepositoryInFile("src\\test\\java\\testResources\\TemeTest.txt",
                validatorTema);

        toFindFirst = new Tema(1,"Descriere",3);
        temaRepo.createInstance("1|Descriere|3");
        temaRepo.createInstance("2|BLABLA|5");
        temaRepo.createInstance("3|DescriereBla|7");
        size = 3;
        toAdd = new Tema(5,"Roby",7);
        elem = temaRepo;
        elemTata = temaRepo;
        return temaRepo;
    }


    @Test
    public void testUpdate() {
        el = fill();
        Tema tema= el.findOne(2);
        tema.setDescriere("Descrierea Modificata");
        el.update(tema);;
        assertEquals("Descrierea Modificata", el.findOne(2).getDescriere());
    }

    @Test
    public void testCreateInstance() {
        el = fill();
        el.createInstance("13|Descriere Test|13");
        HasID student=el.findOne(13);
        assertEquals((Integer)13, (Integer)student.getID());
    }

    @Test
    public void testWriteInstance()//
    {
        el= fill();
        String fileName = "src\\test\\java\\testResources\\TemeTest.txt";
        try(BufferedWriter writer=new BufferedWriter(new FileWriter(fileName))){
            Tema tema = new Tema(1, "Descriere" , 3);
            el.delete(1);
            el.delete(2);
            el.delete(3);
            el.add(tema);
            BufferedReader reader =  new BufferedReader(new FileReader(fileName));
            String rez = (String)reader.readLine();
            assertEquals(rez,"1|Descriere|3");
        }
        catch (Exception e)
        {
            assertEquals(true,false);
        }
    }

    @Test
    public void testCreateInstanceError1()// structura stringului nu e buna
    {
        el = fill();
        try{
            el.createInstance("15|DescriereTest|13|4");
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
            el.createInstance("13|Descriere|numar");
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
            Tema tema = new Tema(9,"Descriere", 5);
            el.writeInstace(null, tema);
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
            TemaRepositoryInFile temarepo =  fill();
            temarepo.setFileName(null);
            Tema tema = new Tema(5,"RobyBubble",4);
            temarepo.add(tema);
            assertEquals(true,false);
        }
        catch(RepositoryException e){
            RepositoryException expect = new RepositoryException("Can't write to file\n");
            assertEquals(expect.toString(),e.toString());
        }

    }

}
