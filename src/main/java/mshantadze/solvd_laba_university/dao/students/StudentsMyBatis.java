package mshantadze.solvd_laba_university.dao.students;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StudentsMyBatis {
	private static final Logger LOGGER = LogManager.getLogger(StudentsMyBatis.class);

	private SqlSessionFactory factory;
	
	public StudentsMyBatis() {
		Reader reader = null;
		try{
            reader = Resources.getResourceAsReader("mybatis-config.xml");
        }catch(IOException e){
            LOGGER.error(e);
        }
		
		factory = new SqlSessionFactoryBuilder().build(reader);
	}
	public void getStudents() {
		SqlSession session = factory.openSession();
		
        try{
        	IStudentsDAO iStudentsDAO = session.getMapper(IStudentsDAO.class);
        	List<Student> students = iStudentsDAO.getStudents();
        	
        	for (Student student : students) {
        		LOGGER.info(student.getFirstName());
        	}
        }finally {
            session.rollback();
            session.close();
        }
	}
}
