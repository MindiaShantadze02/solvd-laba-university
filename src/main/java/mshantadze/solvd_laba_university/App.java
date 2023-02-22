package mshantadze.solvd_laba_university;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import mshantadze.solvd_laba_university.dao.students.StudentsMyBatis;
import mshantadze.solvd_laba_university.parsers.JAXB;
import mshantadze.solvd_laba_university.parsers.Jackson;
import mshantadze.solvd_laba_university.parsers.StudentsDOMParser;
import mshantadze.solvd_laba_university.parsers.StudentsStaXParser;
import mshantadze.solvd_laba_university.parsers.StudentsXMLHandler;
import mshantadze.solvd_laba_university.dao.students.Student;

public class App 
{
    public static void main(String[] args ) throws ParserConfigurationException, SAXException, IOException {
    	/*
    	SAXParserFactory factory = SAXParserFactory.newInstance();
    	SAXParser parser = factory.newSAXParser();
    	parser.parse(new File("src/main/resources/students.xml"), studentsXmlHandler);
    	List<Student> students = studentsXmlHandler.readStudents();
    	
    	for (Student student : students) {
    		System.out.println(student.getFirstName());
    	}
    	StudentsStaXParser studentsReader = new StudentsStaXParser();
    	List<Student> students = studentsReader.readStudents();
    	
    	for (Student student : students) {
    		System.out.println(student.getFirstName());
    	}
    	
    	
    	StudentsDOMParser studentsDOMParser = new StudentsDOMParser();
    	studentsDOMParser.readStudents();
    	
    	JAXB jaxb = new JAXB();
    	
    	jaxb.read();
    	jaxb.write();
    	*/
    	
    	StudentsMyBatis iStudentsMyBatis = new StudentsMyBatis();
    	iStudentsMyBatis.getStudents();
    }
}
