package Repository;

import Domain.HasID;
import ValidatorsAndExceptions.ValidatorStudent;
import org.junit.Test;

import java.io.BufferedWriter;

import static org.junit.Assert.assertEquals;

public abstract class TestRepositoryInFile extends TestRepository{


    AbstractRepositoryInFile elem ;

    String inputLinie;
    String inputFile;//numele fisierului



    @Test
    public void testAdd()
    {
        fill();
        elem.add(toAdd);
        assertEquals(elem.size(),size+1);
    }

    @Test
    public void testDelete()
    {
        fill();
        elem.delete(1);
        assertEquals(size-1, elem.size());
    }

    //Erori!----------------------------------------------------------

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
            RepositoryException expect = new RepositoryException("Exista deja un element cu ID 1");
            assertEquals(expect.toString(),e.toString());
        }
    }

    @Test
    public void testDeleteError()
    {
        fill();
        try{
            elem.delete(toAdd.getID());
            assertEquals(true,false);
        }
        catch(RepositoryException e)
        {
            RepositoryException expect = new RepositoryException("ID "+toAdd.getID()+" nu exista");
            assertEquals(expect.toString(),e.toString());
        }
    }

    @Test
    public void testUpdateError()
    {
        fill();
        try{
            elem.update(toAdd);
            assertEquals(true,false);
        }
        catch(RepositoryException e)
        {
            RepositoryException expect = new RepositoryException("ID "+toAdd.getID()+" nu exista");
            assertEquals(expect.toString(),e.toString());
        }
    }

    @Test
    public void testLoadError()
    {
        ValidatorStudent validator = new ValidatorStudent();
        try {
            AbstractRepositoryInFile repo = new StudentRepositoryInFile("ssa", validator);
            assertEquals(true,false);
        }
        catch(RepositoryException e){
            RepositoryException expect = new RepositoryException("Can't load data from file\n");
            assertEquals(expect.toString(),e.toString());
        }
    }
}
