package mshantadze.solvd_laba_university.dao.lecturers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mshantadze.solvd_laba_university.Gender;
import mshantadze.solvd_laba_university.dao.connectionpool.ConnectionPool;
import mshantadze.solvd_laba_university.dao.students.Student;
import mshantadze.solvd_laba_university.dao.students.StudentsDAO;

public class LecturersDAO implements ILecturersDAO {
	private static final Logger LOGGER = LogManager.getLogger(LecturersDAO.class);
	
	@Override
	public void getLecturers() {
		try {
			Connection connection = ConnectionPool.startPool().getConnection();
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM Lecturer");
			
			while (result.next()) {
				String lecturerId = result.getString("lecturer_id");
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");
				
				LOGGER.info(lecturerId + " " + firstName + " " + lastName);
			}
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public void getLecturer(String id) {
		try {
			Connection connection = ConnectionPool.startPool().getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM Lecturer WHERE lecturer_id = ?");
			
			statement.setString(1, id);
			
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				String lecturerId = result.getString("lecturer_id");
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");
				
				System.out.println(lecturerId + " " + firstName + " " + lastName);
			}
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public void deleteLecturer(Lecturer lecturer) {
		try {
			Connection connection = ConnectionPool.startPool().getConnection();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM Lecturer WHERE lecturer_id = ?");
			statement.setString(1, lecturer.getEmployeeId());
			
			statement.executeUpdate();
			
			System.out.println("Lecturer deleted");
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e.getMessage());
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
			LOGGER.error(e.getMessage());
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
			statement.setString(6, Gender.genderToString(lecturer.getGender()));
			
			statement.executeUpdate();
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}
	
}
