package Repository;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

import Domain.Student;
import Domain.Tema;
import Repository.StudentRepositoryXML;
import Repository.TemaRepositoryXML;
import ValidatorsAndExceptions.ValidatorStudent;
import ValidatorsAndExceptions.ValidatorTema;

public class TestTemeRepositoryXML {

	@Test
	public void testCreateInstance() {
		File fXmlFile = new File("src\\test\\java\\testResources\\TemeXMLTest.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			doc.appendChild(doc.createElement("teme"));
			
			DOMSource domSource = new DOMSource(doc);
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			FileWriter sw = new FileWriter(fXmlFile);
			StreamResult sr = new StreamResult(sw);
			
			transformer.transform(domSource, sr);  
			
			ValidatorTema validatorTema = new ValidatorTema();
			TemaRepositoryXML temeRepo = new TemaRepositoryXML("src\\test\\java\\testResources\\TemeXMLTest.xml",
					validatorTema);

			Element temaE = doc.createElement("tema");
			temaE.setAttribute("nrTema", "2");
			temeRepo.writeInstace(doc, "descriere", "Tema1", temaE);
			temeRepo.writeInstace(doc, "deadline", "3", temaE);

			temeRepo.add(temeRepo.createInstance(temaE));

			Tema tema = temeRepo.findOne(2);

			
			assertEquals((long)2, (long)tema.getID());

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
	}
}
