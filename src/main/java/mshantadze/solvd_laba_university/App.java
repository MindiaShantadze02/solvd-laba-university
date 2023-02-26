package mshantadze.solvd_laba_university;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mshantadze.solvd_laba_university.dao.mybatis.implementation.AdministrationMyBatis;
import mshantadze.solvd_laba_university.models.Employee;

public class App 
{
	private static final Logger LOGGER = LogManager.getLogger(App.class);
	
    public static void main(String[] args ) {
    	List<Employee> employees = new AdministrationMyBatis().getEmployees();
    	
    	for (Employee employee : employees) {
    		System.out.println(employee.getFirstName());
    	}
    }
}
