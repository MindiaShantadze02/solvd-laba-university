package mshantadze.solvd_laba_university.parsers.xml.jaxb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import mshantadze.solvd_laba_university.Gender;
import mshantadze.solvd_laba_university.models.Student;
import mshantadze.solvd_laba_university.models.Students;

public class JAXB {
	private static Logger LOGGER = LogManager.getLogger(JAXB.class);

	public void read() {
		try {
	        FileReader studentsJaxb = new FileReader("src/main/resources/xml/reading/students.xml");
	        JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);
	        
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	        Students students = (Students) jaxbUnmarshaller.unmarshal(studentsJaxb);
	        
	        for (Student student : students.getStudents()) {
	        	LOGGER.info(student.getFirstName());
	        	LOGGER.info(student.getLastName());
	        	LOGGER.info("---------------------");
	        }
	    } catch(JAXBException | FileNotFoundException e){
	    	LOGGER.error(e);
	    }
	}
	
	public void write() {
		try {
			FileReader studentsJaxb = new FileReader("src/main/resources/xml/writing/students.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			Student student = new Student("12345678930", "firstnamethree", "lastnamethree", "595030201", false,
					Gender.MALE, "1", "1999-02-02");
			
			marshaller.marshal(student, new File("src/main/resources/student.xml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e);
		}
		
	}
}
