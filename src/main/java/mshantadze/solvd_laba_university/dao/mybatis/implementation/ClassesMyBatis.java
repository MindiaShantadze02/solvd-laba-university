package mshantadze.solvd_laba_university.dao.mybatis.implementation;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mshantadze.solvd_laba_university.dao.interfaces.IClassesDAO;
import mshantadze.solvd_laba_university.dao.interfaces.IEventsDAO;
import mshantadze.solvd_laba_university.dao.interfaces.IStudentsDAO;
import mshantadze.solvd_laba_university.dao.mybatis.MyBatis;
import mshantadze.solvd_laba_university.models.Student;
import mshantadze.solvd_laba_university.models.UniClass;

public class ClassesMyBatis extends MyBatis implements IClassesDAO {
	private static final Logger LOGGER = LogManager.getLogger(ClassesMyBatis.class);
	
	@Override
	public List<UniClass> getClasses() {
		SqlSession session = factory.openSession();
		List<UniClass> classes = null;
		
        try{
        	IClassesDAO iClassesDAO = session.getMapper(IClassesDAO.class);
        	classes = iClassesDAO.getClasses();
        } catch(Exception e) {
            session.rollback();
        	LOGGER.error(e);
        }
        finally {
            session.close();
        }
        
        return classes;
	}

	@Override
	public UniClass getClass(int id) {
		SqlSession session = factory.openSession();
		UniClass uniClass = null;
		
        try{
        	IClassesDAO iClassesDAO = session.getMapper(IClassesDAO.class);
        	uniClass = iClassesDAO.getClass(id);
        } catch(Exception e) {
            session.rollback();
        	LOGGER.error(e);
        }
        finally {
            session.close();
        }
        
        return uniClass;
	}

	@Override
	public void deleteClass(UniClass uniClass) {
		SqlSession session = factory.openSession();
        try{
        	IClassesDAO iClassesDAO = session.getMapper(IClassesDAO.class);
        	iClassesDAO.deleteClass(uniClass);
        } catch(Exception e) {
            session.rollback();
        	LOGGER.error(e);
        }
        finally {
            session.close();
        }
	}

	@Override
	public void updateClass(UniClass uniClass) {
		SqlSession session = factory.openSession();
        try{
        	IClassesDAO iClassesDAO = session.getMapper(IClassesDAO.class);
        	iClassesDAO.updateClass(uniClass);
        } catch(Exception e) {
            session.rollback();
        	LOGGER.error(e);
        }
        finally {
            session.close();
        }
	}

	@Override
	public void insertClass(UniClass uniClass) {
		SqlSession session = factory.openSession();
        try{
        	IClassesDAO iClassesDAO = session.getMapper(IClassesDAO.class);
        	iClassesDAO.deleteClass(uniClass);
        } catch(Exception e) {
            session.rollback();
        	LOGGER.error(e);
        }
        finally {
            session.close();
        }
	}
}
