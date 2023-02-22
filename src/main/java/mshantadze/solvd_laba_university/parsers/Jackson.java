package mshantadze.solvd_laba_university.parsers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import mshantadze.solvd_laba_university.Gender;
import mshantadze.solvd_laba_university.dao.students.Student;

public class Jackson {
	private static Logger LOGGER = LogManager.getLogger(Jackson.class);
	ObjectMapper om = new ObjectMapper();
	
	public void read() {
		try {
			List<Student> students = (List<Student>) om.readValue(new File("src/main/resources/students.json"), new TypeReference<List<Student>>() {});
			
			for (Student student : students) {
				LOGGER.info(student.getFirstName());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e);
		}
	}
	
	public void write() {
		try {
			Student student = new Student("12345678930", "firstnamethree", "lastnamethree", "595030201", false,
					Gender.MALE, "1", "1999-02-02");
			
			om.writeValue(new File("src/main/resources/student.json"),  student);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e);
		}
	}
}
