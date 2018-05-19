package Repository;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import Domain.Student;
import Domain.Tema;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Domain.Nota;
import Repository.NotaRepositoryInFile;
import Repository.NotaRepositoryXML;
import ValidatorsAndExceptions.ValidatorNota;
import javafx.util.Pair;

public class TestNotaRepositoryXML extends TestRepositoryXML{

	NotaRepositoryXML notaRepositoryXML ;


	public NotaRepositoryXML fill(){
		File fXmlFile = new File("src\\test\\java\\testResources\\CatalogXMLTest.xml");
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

			ValidatorNota validatorNota = new ValidatorNota();
			NotaRepositoryXML noteRepo = new NotaRepositoryXML("src\\test\\java\\testResources\\CatalogXMLTest.xml",
					validatorNota);

			Student a = new Student(1,"Robert",1,"robert@yahoo","Andrei");
			Tema t = new Tema(1,"tema1",3);
			Student aa = new Student(2,"Robert",1,"robert@yahoo","Andrei");
			Tema tt = new Tema(2,"tema1",3);
			Student aaa = new Student(3,"Robert",1,"robert@yahoo","Andrei");
			Tema ttt = new Tema(3,"tema1",3);

			noteRepo.add(new Nota(a,t,1,10));
			noteRepo.add(new Nota(aa,tt,3,7));
			noteRepo.add(new Nota(aaa,ttt,7,9));
			toFindFirst=new Nota(a,t,1,10);

			size = 3;
			toAdd = new Nota(aa,ttt,6,10);
			elem = noteRepo;
			elemTata = noteRepo;
			return noteRepo;

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
		File fXmlFile = new File("src\\test\\java\\testResources\\CatalogXMLTest.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			doc.appendChild(doc.createElement("note"));
			
			DOMSource domSource = new DOMSource(doc);
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			FileWriter sw = new FileWriter(fXmlFile);
			StreamResult sr = new StreamResult(sw);
			
			transformer.transform(domSource, sr);  
			
			ValidatorNota validatorNota = new ValidatorNota();
			NotaRepositoryXML notaRepo = new NotaRepositoryXML("src\\test\\java\\testResources\\CatalogXMLTest.xml",
					validatorNota);

			Element notaE = doc.createElement("nota");
			notaRepo.writeInstace(doc, "idStudent", "2", notaE);
			notaRepo.writeInstace(doc, "idTema", "1", notaE);
			notaRepo.writeInstace(doc, "value", "10", notaE);
			notaRepo.writeInstace(doc, "saptPredare", "3", notaE);

			notaRepo.add(notaRepo.createInstance(notaE));

			Nota nota = notaRepo.findOne(new Pair<Integer, Integer>(2, 1));

			// assertEquals((long)10,(long) note.get(0).getValoare());
			assertEquals(new Pair<Integer, Integer>(2, 1), nota.getID());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void testUpdate() {
		Student a = new Student(1,"Robert",1,"robert@yahoo","Andrei");
		Tema t = new Tema(1,"tema1",3);
		Nota nota = new Nota(a,t,1,10);
		nota.setValoare(9);
		//el.update(nota);
		assertEquals("9", ""+nota.getValoare());
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

	@Test
	@Override
	public void testWriteToFileError(){
		notaRepositoryXML = fill();
		notaRepositoryXML.setFileName(null);
		try {
			notaRepositoryXML.writeToFile();
			assertEquals(true,false);
		}
		catch(RepositoryException e){
			RepositoryException expected = new RepositoryException();
			expected = new RepositoryException("Can't write to XML file\n");
			assertEquals(expected.toString(),e.toString());
		}

	};





}
