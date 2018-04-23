//package Repository;
//
//import Domain.Tema;
//import ValidatorsAndExceptions.ValidatorStudent;
//import ValidatorsAndExceptions.ValidatorTema;
//import org.junit.Test;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerConfigurationException;
//import javax.xml.transform.TransformerException;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.fail;
//
//public class TestTemaRepositoryXML extends TestRepositoryXML{
//
//    TemaRepositoryXML temaRepo;
//
//    public TemaRepositoryXML fill(){
//        File fXmlFile = new File("src\\test\\java\\testResources\\TemeXMLTest.xml");
//        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//        try {
//            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//            Document doc = dBuilder.newDocument();
//            doc.appendChild(doc.createElement("teme"));
//
//            DOMSource domSource = new DOMSource(doc);
//            Transformer transformer = TransformerFactory.newInstance().newTransformer();
//            FileWriter sw = new FileWriter(fXmlFile);
//            StreamResult sr = new StreamResult(sw);
//
//            transformer.transform(domSource, sr);
//
//            ValidatorTema validatorTema = new ValidatorTema();
//            TemaRepositoryXML temaRepo = new TemaRepositoryXML("src\\test\\java\\testResources\\TemeXMLTest.xml",
//                    validatorTema);
//
//            temaRepo.add(new Tema(1,"Descriere",1));
//            temaRepo.add(new Tema(2,"RobyBubble",3));
//            temaRepo.add(new Tema(3,"TemaVVSS",5));
//            toFindFirst = new Tema(1,"Descriere",1);
//            size = 3;
//            toAdd = new Tema(4,"TemaNoua",7);
//            elem = temaRepo;
//            elemTata = temaRepo;
//            return temaRepo;
//
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            fail();
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//            fail();
//        } catch (TransformerConfigurationException e) {
//            e.printStackTrace();
//            fail();
//        } catch (TransformerException e) {
//            e.printStackTrace();
//            fail();
//        }
//        String a=null;
//        a.toCharArray();
//        return null;
//    }
//
//    @Test
//    public void testCreateInstance() {
//        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//        try {
//            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//            Document doc = dBuilder.newDocument();
//            doc.appendChild(doc.createElement("teme"));
//
//            ValidatorTema validatorTema = new ValidatorTema();
//            TemaRepositoryXML temaRepo = fill();
//            Element studentE = doc.createElement("student");
//            studentE.setAttribute("id", "1");
//            studentRepo.writeInstace(doc, "nume", "Roby", studentE);
//            studentRepo.writeInstace(doc, "grupa", "1", studentE);
//            studentRepo.writeInstace(doc, "email", "roby@yahoo", studentE);
//            studentRepo.writeInstace(doc, "cadruDidactic", "Serban", studentE);
//            Student stud = studentRepo.createInstance(studentE);
//            assertEquals(stud.getEmail(),"roby@yahoo");
//        }
//        catch (ParserConfigurationException e)
//        {
//            System.out.print(e);
//            assertEquals(true,false);
//        }
//    }
//}
