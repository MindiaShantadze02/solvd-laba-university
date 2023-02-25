package mshantadze.solvd_laba_university.dao.mybatis.implementation;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mshantadze.solvd_laba_university.dao.interfaces.IStudentsDAO;
import mshantadze.solvd_laba_university.dao.mybatis.MyBatis;
import mshantadze.solvd_laba_university.models.Student;

public class StudentsMyBatis extends MyBatis {
	private static final Logger LOGGER = LogManager.getLogger(StudentsMyBatis.class);

	public void getStudents() {
		SqlSession session = factory.openSession();
		
        try{
        	IStudentsDAO iStudentsDAO = session.getMapper(IStudentsDAO.class);
        	List<Student> students = iStudentsDAO.getStudents();
        	
        	for (Student student : students) {
        		System.out.println(student.getFirstName());
        	}
        }finally {
            session.rollback();
            session.close();
        }
	}
}
