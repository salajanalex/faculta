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

public class TestNotaRepositoryXML {

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

}
