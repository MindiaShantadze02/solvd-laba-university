package mshantadze.solvd_laba_university.parsers.xml.default_parsers.students;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mshantadze.solvd_laba_university.Gender;
import mshantadze.solvd_laba_university.models.Student;

public class StudentsStaXParser {
	private static Logger LOGGER = LogManager.getLogger(StudentsStaXParser.class);
	private List<Student> students;
	private Student currentStudent;
	
	public List<Student> readStudents() {
		try {
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLEventReader reader = factory.createXMLEventReader(new FileInputStream("src/main/resources/xml/reading/students.xml"));
			
			while (reader.hasNext()) {
				XMLEvent nextEvent = reader.nextEvent();

				if (nextEvent.isStartElement()) {
					StartElement startElement = nextEvent.asStartElement();
					
					switch (startElement.getName().getLocalPart()) {
						case "students":
							students = new ArrayList();
							break;
						case "student":
							nextEvent = reader.nextEvent();
							currentStudent = new Student();
							break;
						case "firstName":
							nextEvent = reader.nextEvent();
							currentStudent.setFirstName(nextEvent.asCharacters().getData());
							break;
						case "lastName":
							nextEvent = reader.nextEvent();
							currentStudent.setLastName(nextEvent.asCharacters().getData());
							break;
						case "phoneNumber":
							nextEvent = reader.nextEvent();
							currentStudent.setLastName(nextEvent.asCharacters().getData());
							break;
						case "active":
							nextEvent = reader.nextEvent();
							Characters characters = nextEvent.asCharacters();
							
							if (characters.getData() == "true") currentStudent.setActive(true);
							else currentStudent.setActive(false);
							
							break;
						case "gender":
							nextEvent = reader.nextEvent();
							currentStudent.setGender(nextEvent.asCharacters().getData());
							break;
						case "level":
							nextEvent = reader.nextEvent();
							currentStudent.setLevel(nextEvent.asCharacters().getData());
							break;
						case "birthDate":
							nextEvent = reader.nextEvent();
							currentStudent.setBirthDate(nextEvent.asCharacters().getData());
							break;
					}
				} else if (nextEvent.isEndElement()) {
					 EndElement endElement = nextEvent.asEndElement();
					 if (endElement.getName().getLocalPart() == "student") {
						 this.students.add(currentStudent);
					 };
				}
			}
		} catch (FileNotFoundException | XMLStreamException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e);
		}
		
		
		return students;
	}
}
