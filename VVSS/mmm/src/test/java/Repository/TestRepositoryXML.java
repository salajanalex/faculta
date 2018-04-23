package Repository;

import Domain.Student;
import ValidatorsAndExceptions.ValidatorStudent;
import org.junit.Test;
import org.w3c.dom.Document;

import javax.annotation.processing.Filer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

public abstract class TestRepositoryXML extends TestRepository {


    AbstractRepositoryXML elem ;


    @Test
    public void testLoadData() {
        try {
            File fXmlFile = new File("src\\test\\java\\testResources\\StudentiXMLTest.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            doc.appendChild(doc.createElement("students"));
            DOMSource domSource = new DOMSource(doc);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            FileReader sw = new FileReader(fXmlFile);
            StreamResult sr = new StreamResult("src\\test\\java\\testResources\\StudentiXMLTest.xml");
            transformer.transform(domSource, sr);
            ValidatorStudent validatorStudent = new ValidatorStudent();
            StudentRepositoryXML studentRepo = new StudentRepositoryXML("src\\test\\java\\testResources\\StudentiXMLTest.xml",
                        validatorStudent);
            elem = studentRepo;
            int size = elem.size();
            elem.loadData();
            assertEquals(true,true);
        }
        catch (Exception e) {
            assertEquals(true,false);
        }
    }

    //Crud
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


    //Error!----------------------------------------------------------

    @Test
    public void testWriteToFileError()
    {
        fill();
        elem.setFileName(null);
        try {
            elem.delete(1);
            assertEquals(true, false);
        }catch (RepositoryException e)
        {
            RepositoryException expected = new RepositoryException("Can't write to XML file\n");
            assertEquals(expected.toString(), e.toString());
        }

    }

    @Test
    public void testLoadDataError()//??????
    {
        fill();
        int size = elem.size();
        try {
            elem.loadData();
            assertEquals(true,false);
        }
        catch (RepositoryException e) {
            RepositoryException expected = new RepositoryException("Can't load data from XML\n");
            assertEquals(expected.toString(), e.toString());
        }
    }

    //Crud
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
    public void testLoadDocumentError(){
        try {
            ValidatorStudent validatorStudent = new ValidatorStudent();
            StudentRepositoryXML studentRepo = new StudentRepositoryXML(null,
                    validatorStudent);
            assertEquals(true,false);
        }
        catch (RepositoryException e) {
            RepositoryException expect = new RepositoryException("Can't load Document\n");
            assertEquals(expect.toString(),e.toString());
        }
    }

}
