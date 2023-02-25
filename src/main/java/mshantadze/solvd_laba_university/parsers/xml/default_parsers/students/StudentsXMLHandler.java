package mshantadze.solvd_laba_university.parsers.xml.default_parsers.students;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import mshantadze.solvd_laba_university.Gender;
import mshantadze.solvd_laba_university.models.Student;

public class StudentsXMLHandler extends DefaultHandler {
	private static Logger LOGGER = LogManager.getLogger(StudentsXMLHandler.class);
	List<Student> students;
	Student currentStudent;
	
	String currentTag;
	
	@Override
	public void startElement (String uri, String localName,  String qName, Attributes a) {
		currentTag = qName;
		switch (qName) {
			case "students":
				students = new ArrayList<>();
				break;
			case "student":
				currentStudent = new Student();
				break;
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) {
		String value = "";
		for (int i = 0; i < length; i++) {
			value += ch[start + i];
		}
		
		switch (currentTag) {
			case "firstName":
				currentStudent.setFirstName(value); 
				break;
			case "lastName":
				currentStudent.setLastName(value);
				break;
			case "phoneNumber":
				currentStudent.setPhoneNumber(value);
				break;
			case "active":
				if (value == "true") currentStudent.setActive(true);
				else currentStudent.setActive(false);
				break;
			case "gender":
				currentStudent.setGender(value);
				break;
			case "level":
				currentStudent.setLevel(value);
				break;
			case "birthDate":
				currentStudent.setBirthDate(value);
				break;
		}
	}
	
	@Override
	public void endElement (String uri, String localName, String qName) {
		currentTag = "";
		switch (qName) {
			case "student":
				this.students.add(currentStudent);
				break;
		}
	}
	
	public List<Student> readStudents() {
		return this.students;
	}
}
