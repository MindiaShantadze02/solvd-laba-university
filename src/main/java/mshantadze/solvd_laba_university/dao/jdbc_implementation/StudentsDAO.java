package mshantadze.solvd_laba_university.dao.jdbc_implementation;

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
import mshantadze.solvd_laba_university.dao.interfaces.IStudentsDAO;
import mshantadze.solvd_laba_university.models.Student;

public class StudentsDAO implements IStudentsDAO {
	private static final Logger LOGGER = LogManager.getLogger(StudentsDAO.class);

	@Override
	public ArrayList<Student> getStudents() {
		ArrayList<Student> students = new ArrayList<>();
		try {
			Connection connection = ConnectionPool.startPool().getConnection();
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM Students");
			
			while (result.next()) {
				String studentId = result.getString("student_id");
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");
				String phoneNumber = result.getString("phone_number");
				boolean isActive = result.getBoolean("active");
				Gender gender = Gender.getGender(result.getString("gender"));
				String level = result.getString("level");
				String birthDate = result.getString("birth_date");
				
				Student student = new Student(studentId, firstName, lastName, phoneNumber, isActive, gender, level, birthDate);
				LOGGER.info(studentId + " " + firstName + " " + lastName + " " + gender);
			}
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e.getMessage());
		}
		
		return students;
	}

	@Override
	public Student getStudent(String id) {
		Student student = null;
		try {
			Connection connection = ConnectionPool.startPool().getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM Students WHERE student_id = ?");
			statement.setString(1, id);
			
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				String studentId = result.getString("student_id");
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");
				String phoneNumber = result.getString("phone_number");
				boolean isActive = result.getBoolean("active");
				Gender gender = Gender.getGender(result.getString("gender"));
				String level = result.getString("level");
				String birthDate = result.getString("birth_date");
				
				student = new Student(studentId, firstName, lastName, phoneNumber, isActive, gender, level, birthDate);
				System.out.println(studentId + " " + firstName + " " + lastName + " " + gender);
			}
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e.getMessage());
		}
		
		return student;
	}

	@Override
	public void deleteStudent(Student student) {
		try {
			Connection connection = ConnectionPool.startPool().getConnection();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM Students WHERE student_id = ?");
			statement.setString(1, student.getStudentId());
			
			statement.executeUpdate();
			
			LOGGER.info("Student deleted");
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public void updateStudent(Student student) {
		try {
			Connection connection = ConnectionPool.startPool().getConnection();
			PreparedStatement statement = connection.prepareStatement("UPDATE Students SET first_name = ?, last_name = ?, gender = ? WHERE student_id = ?");
			
			statement.setString(1, student.getFirstName());
			statement.setString(2, student.getLastName());
			statement.setString(3, Gender.genderToString(student.getGender()));
			statement.setString(4, student.getStudentId());
			
			statement.executeUpdate();
			
			LOGGER.info("Student with id " + student.getStudentId() + " is updated");
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e.getMessage());
		}

	}

	@Override
	public void insertStudent(Student student) {
		try {
			Connection connection = ConnectionPool.startPool().getConnection();
			PreparedStatement statement = connection.prepareStatement("INSERT INTO Students (student_id, first_name, last_name, phone_number, active, gender, level, birth_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

			statement.setString(1, student.getStudentId());
			statement.setString(2, student.getFirstName());
			statement.setString(3, student.getLastName());
			statement.setString(4, student.getPhoneNumber());
			statement.setBoolean(5, student.isActive());
			statement.setString(6, Gender.genderToString(student.getGender()));
			statement.setString(7, student.getLevel());
			statement.setString(8, student.getBirthDate());
			
			statement.executeUpdate();
			
			LOGGER.info("Inserted new student into the database");
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}

}
