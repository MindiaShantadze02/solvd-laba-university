package mshantadze.solvd_laba_university.dao.jdbc_implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mshantadze.solvd_laba_university.dao.connectionpool.ConnectionPool;
import mshantadze.solvd_laba_university.dao.interfaces.IAdministrationDAO;
import mshantadze.solvd_laba_university.models.Employee;

public class AdministrationDAO implements IAdministrationDAO {
	private static final Logger LOGGER = LogManager.getLogger(AdministrationDAO.class);
	
	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		
		try {
			Connection connection = ConnectionPool.startPool().getConnection();
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM Administration");
			
			while (result.next()) {
				Employee employee = new Employee();
				employee.setEmployeeId(result.getString("employee_id"));
				employee.setFirstName(result.getString("first_name"));
				employee.setLastName(result.getString("last_name"));
				employee.setGender(result.getString("gender"));
				employee.setPhoneNumber(result.getString("phone_number"));
				employee.setRole(result.getString("role"));
				employees.add(employee);
			}
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e.getMessage());
		}
		
		return employees;
	}

	@Override
	public Employee getEmployee(String id) {
		Employee employee = new Employee();
		try {
			Connection connection = ConnectionPool.startPool().getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM Administration WHERE employee_id = ?");
			
			statement.setString(1, id);
			
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				employee.setEmployeeId(result.getString("employee_id"));
				employee.setFirstName(result.getString("first_name"));
				employee.setLastName(result.getString("last_name"));
				employee.setGender(result.getString("gender"));
				employee.setPhoneNumber(result.getString("phone_number"));
				employee.setRole(result.getString("role"));
			}
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e.getMessage());
		}
		
		return employee;
	}

	@Override
	public void deleteEmployee(Employee employee) {
		try {
			Connection connection = ConnectionPool.startPool().getConnection();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM Administration WHERE employee_id = ?");
			statement.setString(1, employee.getEmployeeId());
			
			statement.executeUpdate();
			
			System.out.println("Employee deleted");
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public void updateEmployee(Employee employee) {
		try {
			Connection connection = ConnectionPool.startPool().getConnection();
			PreparedStatement statement = connection.prepareStatement("UPDATE INTO Administration SET first_name = ?, last_name = ? WHERE employee_id = ?");
			
			statement.setString(1, "John");
			statement.setString(2, "Doe");
			statement.setString(3, employee.getEmployeeId());
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public void insertEmployee(Employee employee) {
		try {
			Connection connection = ConnectionPool.startPool().getConnection();
			PreparedStatement statement = connection.prepareStatement("INSERT INTO Administration (employee_id, first_name, last_name, role, phone_number, gender, department_id) VALUES (?,?,?,?,?,?)");

			statement.setString(1, employee.getEmployeeId());
			statement.setString(2, employee.getFirstName());
			statement.setString(3, employee.getLastName());
			statement.setString(4, employee.getRole());
			statement.setString(5, employee.getPhoneNumber());
			statement.setString(6, employee.getGender());
			statement.setInt(7, employee.getDepartmentId());
			
			statement.executeUpdate();
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}

}
