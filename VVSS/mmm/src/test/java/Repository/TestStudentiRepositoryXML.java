package Repository;

import static org.junit.Assert.*;

import java.io.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import Domain.Nota;
import Domain.Student;
import Repository.NotaRepositoryXML;
import Repository.StudentRepositoryXML;
import ValidatorsAndExceptions.ValidatorNota;
import ValidatorsAndExceptions.ValidatorStudent;
import javafx.util.Pair;

public class TestStudentiRepositoryXML extends TestRepositoryXML {

	StudentRepositoryXML studRepo ;

	public StudentRepositoryXML fill(){
		File fXmlFile = new File("src\\test\\java\\testResources\\StudentiXMLTest.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			doc.appendChild(doc.createElement("students"));

			DOMSource domSource = new DOMSource(doc);
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			FileWriter sw = new FileWriter(fXmlFile);
			StreamResult sr = new StreamResult(sw);

			transformer.transform(domSource, sr);

			ValidatorStudent validatorStudent = new ValidatorStudent();
			StudentRepositoryXML studentRepo = new StudentRepositoryXML("src\\test\\java\\testResources\\StudentiXMLTest.xml",
					validatorStudent);

			studentRepo.add(new Student(1,"Robert",1,"robert@yahoo","Serban"));
			studentRepo.add(new Student(2,"Roby",1,"roby@yahoo","Serban"));
			studentRepo.add(new Student(3,"Andrei",1,"andrei@yahoo","Serban"));
			toFindFirst = new Student(1,"Robert",1,"robert@yahoo","Serban");
			size = 3;
			toAdd = new Student(4,"Roby",1,"roby@yahoo","Serban");
			elem = studentRepo;
			elemTata = studentRepo;
			return studentRepo;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			fail();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
			fail();
		} catch (TransformerException e) {
			e.printStackTrace();
			fail();
		}
		String a=null;
		a.toCharArray();
		return null;
	}

	@Test
	public void testCreateInstance() {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			doc.appendChild(doc.createElement("students"));

			ValidatorStudent validatorStudent = new ValidatorStudent();
			StudentRepositoryXML studentRepo = fill();
			Element studentE = doc.createElement("student");
			studentE.setAttribute("id", "1");
			studentRepo.writeInstace(doc, "nume", "Roby", studentE);
			studentRepo.writeInstace(doc, "grupa", "1", studentE);
			studentRepo.writeInstace(doc, "email", "roby@yahoo", studentE);
			studentRepo.writeInstace(doc, "cadruDidactic", "Serban", studentE);
			Student stud = studentRepo.createInstance(studentE);
			assertEquals(stud.getEmail(),"roby@yahoo");
		}
		catch (ParserConfigurationException e)
		{
			System.out.print(e);
			assertEquals(true,false);
		}
	}
	

	@Test
	public void testUpdate() {

		studRepo=fill();

		Student student= studRepo.findOne(2);
		student.setEmail("andrei99@yahoo");

		studRepo.update(student);

		assertEquals("andrei99@yahoo", studRepo.findOne(2).getEmail());
	}



}
