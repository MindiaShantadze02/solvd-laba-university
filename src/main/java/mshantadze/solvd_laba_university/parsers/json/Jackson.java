package mshantadze.solvd_laba_university.parsers.json;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import mshantadze.solvd_laba_university.Gender;
import mshantadze.solvd_laba_university.models.Student;

public class Jackson {
	private static Logger LOGGER = LogManager.getLogger(Jackson.class);
	ObjectMapper om = new ObjectMapper();
	
	public Jackson() {
		SimpleDateFormat  dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		om.setDateFormat(dateFormat);
	}
	
	public void read() {
		try {
			List<Student> students = (List<Student>) om.readValue(new File("src/main/resources/json/reading/students.json"), new TypeReference<List<Student>>() {});
			
			for (Student student : students) {
				LOGGER.info(student.getFirstName());
				LOGGER.info(student.getBirthDate().formatted("yyyy-mm-dd"));
			}
		} catch (IOException e) {
			LOGGER.error(e);
		}
	}
	
	public void write() {
		try {
			Student student = new Student("12345678930", "firstnamethree", "lastnamethree", "595030201", false,
					Gender.MALE, "1", "1999-02-02");
			
			om.writeValue(new File("src/main/resources/json/writing/student.json"),  student);
		} catch (IOException e) {
			LOGGER.error(e);
		}
	}
}
