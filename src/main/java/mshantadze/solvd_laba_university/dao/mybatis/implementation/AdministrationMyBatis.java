package mshantadze.solvd_laba_university.dao.mybatis.implementation;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mshantadze.solvd_laba_university.dao.interfaces.IAdministrationDAO;
import mshantadze.solvd_laba_university.dao.mybatis.MyBatis;
import mshantadze.solvd_laba_university.models.Employee;

public class AdministrationMyBatis extends MyBatis implements IAdministrationDAO {
	private static final Logger LOGGER = LogManager.getLogger(AdministrationMyBatis.class);
	
	@Override
	public List<Employee> getEmployees() {
		SqlSession session = factory.openSession();
		List<Employee> employees = null;
		
        try{
        	IAdministrationDAO iAdministrationDAO = session.getMapper(IAdministrationDAO.class);
        	employees = iAdministrationDAO.getEmployees();
        } catch(Exception e) {
            session.rollback();
        	LOGGER.error(e);
        }
        finally {
            session.close();
        }
        
        return employees;
	}

	@Override
	public Employee getEmployee(String id) {
		SqlSession session = factory.openSession();
		Employee employee = null;
        try{
        	IAdministrationDAO iAdministrationDAO = session.getMapper(IAdministrationDAO.class);
        	employee = iAdministrationDAO.getEmployee(id);
        } catch(Exception e) {
            session.rollback();
        	LOGGER.error(e);
        }
        finally {
            session.close();
        }
        
        return employee;
	}

	@Override
	public void deleteEmployee(Employee employee) {
		SqlSession session = factory.openSession();
        try{
        	IAdministrationDAO iAdministrationDAO = session.getMapper(IAdministrationDAO.class);
        	iAdministrationDAO.deleteEmployee(employee);
        } catch(Exception e) {
            session.rollback();
        	LOGGER.error(e);
        }
        finally {
            session.close();
        }
	}

	@Override
	public void updateEmployee(Employee employee) {
		SqlSession session = factory.openSession();
        try{
        	IAdministrationDAO iAdministrationDAO = session.getMapper(IAdministrationDAO.class);
        	iAdministrationDAO.updateEmployee(employee);
        } catch(Exception e) {
            session.rollback();
        	LOGGER.error(e);
        }
        finally {
            session.close();
        }
	}

	@Override
	public void insertEmployee(Employee employee) {
		SqlSession session = factory.openSession();
        try{
        	IAdministrationDAO iAdministrationDAO = session.getMapper(IAdministrationDAO.class);
        	iAdministrationDAO.insertEmployee(employee);
        } catch(Exception e) {
            session.rollback();
        	LOGGER.error(e);
        }
        finally {
            session.close();
        }
	}
	
}
