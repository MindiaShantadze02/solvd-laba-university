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

public class StudentsMyBatis extends MyBatis implements IStudentsDAO {
	private static final Logger LOGGER = LogManager.getLogger(StudentsMyBatis.class);

	public List<Student> getStudents() {
		SqlSession session = factory.openSession();
		List<Student> students = null;
		
        try{
        	IStudentsDAO iStudentsDAO = session.getMapper(IStudentsDAO.class);
        	students = iStudentsDAO.getStudents();
        } catch(Exception e) {
            session.rollback();
        	LOGGER.error(e);
        }
        finally {
            session.close();
        }
        
        return students;
	}

	@Override
	public Student getStudent(String id) {
		SqlSession session = factory.openSession();
		Student student = null;
		
		try{
        	IStudentsDAO iStudentsDAO = session.getMapper(IStudentsDAO.class);
        	student = iStudentsDAO.getStudent(id);
        } catch(Exception e) {
            session.rollback();
        	LOGGER.error(e);
        }
        finally {
            session.close();
        }
		
		return student;
	}

	@Override
	public void deleteStudent(Student studentArg) {
		SqlSession session = factory.openSession();
		
		try{
        	IStudentsDAO iStudentsDAO = session.getMapper(IStudentsDAO.class);
        	iStudentsDAO.deleteStudent(studentArg);
        	LOGGER.info("Student deleted successfully");
        } catch(Exception e) {
            session.rollback();
        	LOGGER.error(e);
        }
        finally {
            session.close();
        }
	}

	@Override
	public void updateStudent(Student studentArg) {
		SqlSession session = factory.openSession();
		
		try{
        	IStudentsDAO iStudentsDAO = session.getMapper(IStudentsDAO.class);
        	iStudentsDAO.updateStudent(studentArg);
        	LOGGER.info("Student updated successfully");
        } catch(Exception e) {
            session.rollback();
        	LOGGER.error(e);
        }
        finally {
            session.close();
        }
	}

	@Override
	public void insertStudent(Student studentArg) {
		SqlSession session = factory.openSession();
		
		try{
        	IStudentsDAO iStudentsDAO = session.getMapper(IStudentsDAO.class);
        	iStudentsDAO.insertStudent(studentArg);
        	LOGGER.info("Student inserted successfully");
        } catch(Exception e) {
            session.rollback();
        	LOGGER.error(e);
        }
        finally {
            session.close();
        }
	}
}
