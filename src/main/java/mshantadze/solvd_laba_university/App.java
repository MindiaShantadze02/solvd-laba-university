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

import mshantadze.solvd_laba_university.dao.mybatis.implementation.StudentsMyBatis;
import mshantadze.solvd_laba_university.models.Student;
import mshantadze.solvd_laba_university.parsers.json.Jackson;
import mshantadze.solvd_laba_university.parsers.xml.default_parsers.students.StudentsDOMParser;
import mshantadze.solvd_laba_university.parsers.xml.default_parsers.students.StudentsStaXParser;
import mshantadze.solvd_laba_university.parsers.xml.default_parsers.students.StudentsXMLHandler;
import mshantadze.solvd_laba_university.parsers.xml.jaxb.JAXB;

public class App 
{
    public static void main(String[] args ) {
    	StudentsMyBatis studentsMyBatis = new StudentsMyBatis();
    	studentsMyBatis.getStudents();
    }
}
