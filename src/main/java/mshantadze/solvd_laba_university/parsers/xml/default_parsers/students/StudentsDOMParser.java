package mshantadze.solvd_laba_university.parsers.xml.default_parsers.students;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import mshantadze.solvd_laba_university.models.Student;

public class StudentsDOMParser {
	private static Logger LOGGER = LogManager.getLogger(StudentsDOMParser.class);
	
	public Student readStudents() {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			Document doc = db.parse(new File("src/main/resources/xml/reading/students.xml"));
			
			NodeList studentNodes = doc.getElementsByTagName("student");
			
			for (int i = 0; i < studentNodes.getLength(); i++) {
				Node studentNode = studentNodes.item(i);
				NodeList studentNodeChildren = studentNode.getChildNodes();
				
				for (int j = 0; j < studentNodeChildren.getLength(); j++) {
					LOGGER.info(studentNodeChildren.item(j).getTextContent());
				}
				
				LOGGER.info("-----------------------------");
			}
		} catch (ParserConfigurationException e) {
			LOGGER.error(e);
		} catch (SAXException e) {
			LOGGER.error(e);
		} catch (IOException e) {
			LOGGER.error(e);
		}
		return null;
	}
}
