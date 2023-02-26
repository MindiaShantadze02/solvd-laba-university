package mshantadze.solvd_laba_university.dao.mybatis.implementation;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mshantadze.solvd_laba_university.dao.interfaces.ILecturersDAO;
import mshantadze.solvd_laba_university.dao.interfaces.IStudentsDAO;
import mshantadze.solvd_laba_university.dao.mybatis.MyBatis;
import mshantadze.solvd_laba_university.models.Lecturer;
import mshantadze.solvd_laba_university.models.Student;

public class LecturersMyBatis extends MyBatis implements ILecturersDAO {
	private static final Logger LOGGER = LogManager.getLogger(StudentsMyBatis.class);

	@Override
	public List<Lecturer> getLecturers() {
		SqlSession session = factory.openSession();
		List<Lecturer> lecturers = null;
		
        try{
        	ILecturersDAO iLecturersDAO = session.getMapper(ILecturersDAO.class);
        	lecturers = iLecturersDAO.getLecturers();
        } catch(Exception e) {
            session.rollback();
        	LOGGER.error(e);
        }
        finally {
            session.close();
        }
        
        return lecturers;
	}

	@Override
	public Lecturer getLecturer(String id) {
		SqlSession session = factory.openSession();
		Lecturer lecturer = null;
		
        try{
        	ILecturersDAO iLecturersDAO = session.getMapper(ILecturersDAO.class);
        	lecturer = iLecturersDAO.getLecturer(id);
        } catch(Exception e) {
            session.rollback();
        	LOGGER.error(e);
        }
        finally {
            session.close();
        }
        
        return lecturer;
	}

	@Override
	public void deleteLecturer(Lecturer lecturer) {
		SqlSession session = factory.openSession();
		
        try{
        	ILecturersDAO iLecturersDAO = session.getMapper(ILecturersDAO.class);
        	iLecturersDAO.deleteLecturer(lecturer);
        } catch(Exception e) {
            session.rollback();
        	LOGGER.error(e);
        }
        finally {
            session.close();
        }
	}

	@Override
	public void updateLecturer(Lecturer lecturer) {
		SqlSession session = factory.openSession();
		
        try{
        	ILecturersDAO iLecturersDAO = session.getMapper(ILecturersDAO.class);
        	iLecturersDAO.updateLecturer(lecturer);
        } catch(Exception e) {
            session.rollback();
        	LOGGER.error(e);
        }
        finally {
            session.close();
        }
	}

	@Override
	public void insertLecturer(Lecturer lecturer) {
		SqlSession session = factory.openSession();
		
        try{
        	ILecturersDAO iLecturersDAO = session.getMapper(ILecturersDAO.class);
        	iLecturersDAO.insertLecturer(lecturer);
        } catch(Exception e) {
            session.rollback();
        	LOGGER.error(e);
        }
        finally {
            session.close();
        }
	}

}
