package Repository;

import Domain.HasID;
import Repository.AbstractRepository;
import Repository.RepositoryException;
import Repository.StudentRepositoryInFile;
import ValidatorsAndExceptions.ValidatorStudent;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static org.junit.Assert.assertEquals;

public abstract class TestRepository {

    AbstractRepository elemTata ;
    int size;//nr de elemente din elem
    HasID toAdd;//element inexistent in elem!
    HasID toFindFirst;//element din elem cu id = 1

    @Test
    public void testFindOne(){
        //are nevoie de toFindFirst = elementul cu id =1
        fill();
        assertEquals(toFindFirst.toString(),elemTata.findOne(1).toString());
    }

    @Test
    public void testSize()
    {
        fill();
        assertEquals(3,elemTata.size());
    }

    @Test
    public abstract void testAdd();

    @Test
    public abstract void testUpdate();//

    @Test
    public abstract void testDelete();

    //Erori!----------------------------------------------------------


    @Test
    public abstract void testAddError();

    @Test
    public abstract void testDeleteError();

    @Test
    public abstract void testUpdateError();

    @Test
    public void testFindOneError()
    {
        fill();
        try{
            elemTata.findOne(toAdd.getID());
            assertEquals(true,false);
        }
        catch(RepositoryException e)
        {
            RepositoryException expect = new RepositoryException("ID "+toAdd.getID()+" nu exista");
            assertEquals(expect.toString(),e.toString());
        }
    }



    /*
     * Seteaza urmatoarele variabile!!!:
     *      elem = elementu nostru
     *      size = cate elemente contine (rog minim 2!)
     *      toAdd =  un element valid de adaugat (Element inexistent in elem!!)
     *      toFindFirst = elementul cu id-ul 1 din elem
     *
     * HasId se instantiaza cu clasa specifica (Student , Nota ......
     * elem se instantiaza cu clasa specifica (StudentRepository ...
     */
    public abstract AbstractRepository fill();
}
