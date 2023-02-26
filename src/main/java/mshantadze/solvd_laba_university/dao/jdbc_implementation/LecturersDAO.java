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
import mshantadze.solvd_laba_university.dao.interfaces.ILecturersDAO;
import mshantadze.solvd_laba_university.models.Lecturer;

public class LecturersDAO implements ILecturersDAO {
	private static final Logger LOGGER = LogManager.getLogger(LecturersDAO.class);
	
	@Override
	public List<Lecturer> getLecturers() {
		List<Lecturer> lecturers = new ArrayList<>();
		try {
			Connection connection = ConnectionPool.startPool().getConnection();
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM Lecturer");
			
			while (result.next()) {
				Lecturer lecturer = new Lecturer();
				lecturer.setEmployeeId(result.getString("employee_id"));
				lecturer.setFirstName(result.getString("first_name"));
				lecturer.setLastName(result.getString("last_name"));
				lecturer.setGender(result.getString("gender"));
				lecturer.setPhoneNumber(result.getString("phone_number"));
				lecturer.setDepartmentId(result.getInt("department_id"));
				lecturer.setClassId(result.getInt("class_id"));
				lecturers.add(lecturer);
			}
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e);
		}
		
		return lecturers;
	}

	@Override
	public Lecturer getLecturer(String id) {
		Lecturer lecturer = new Lecturer();
		try {
			Connection connection = ConnectionPool.startPool().getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM Lecturer WHERE lecturer_id = ?");
			
			statement.setString(1, id);
			
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				lecturer.setEmployeeId(result.getString("employee_id"));
				lecturer.setFirstName(result.getString("first_name"));
				lecturer.setLastName(result.getString("last_name"));
				lecturer.setGender(result.getString("gender"));
				lecturer.setPhoneNumber(result.getString("phone_number"));
				lecturer.setDepartmentId(result.getInt("department_id"));
				lecturer.setClassId(result.getInt("class_id"));
			}
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e);
		}
		
		return lecturer;
	}

	@Override
	public void deleteLecturer(Lecturer lecturer) {
		try {
			Connection connection = ConnectionPool.startPool().getConnection();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM Lecturer WHERE lecturer_id = ?");
			statement.setString(1, lecturer.getEmployeeId());
			
			statement.executeUpdate();
			
			LOGGER.info("Lecturer deleted");
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e);
		}
	}

	@Override
	public void updateLecturer(Lecturer lecturer) {
		try {
			Connection connection = ConnectionPool.startPool().getConnection();
			PreparedStatement statement = connection.prepareStatement("UPDATE INTO Lecturer SET first_name = ?, last_name = ? WHERE lecturer_id = ?");
			
			statement.setString(1, "John");
			statement.setString(2, "Doe");
			statement.setString(3, lecturer.getEmployeeId());
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e);
		}
	}

	@Override
	public void insertLecturer(Lecturer lecturer) {
		try {
			Connection connection = ConnectionPool.startPool().getConnection();
			PreparedStatement statement = connection.prepareStatement("INSERT INTO Lecturer (lecturer_id, first_name, last_name, phone_number, birth_date, gender) VALUES (?, ?, ?, ?, ?, ?)");

			statement.setString(1, lecturer.getEmployeeId());
			statement.setString(2, lecturer.getFirstName());
			statement.setString(3, lecturer.getLastName());
			statement.setString(4, lecturer.getPhoneNumber());
			statement.setString(5, lecturer.getBirthDate());
			statement.setString(6, lecturer.getGender());
			
			statement.executeUpdate();
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e);
		}
	}
	
}
