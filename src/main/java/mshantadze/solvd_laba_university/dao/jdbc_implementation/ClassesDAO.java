package mshantadze.solvd_laba_university.dao.jdbc_implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mshantadze.solvd_laba_university.Gender;
import mshantadze.solvd_laba_university.dao.connectionpool.ConnectionPool;
import mshantadze.solvd_laba_university.dao.interfaces.IClassesDAO;
import mshantadze.solvd_laba_university.models.Student;
import mshantadze.solvd_laba_university.models.UniClass;

public class ClassesDAO implements IClassesDAO {
	private static final Logger LOGGER = LogManager.getLogger(StudentsDAO.class);
	
	@Override
	public void getClasses() {
		try {
			Connection connection = ConnectionPool.startPool().getConnection();
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM Classes");
			
			while (result.next()) {
				int classId = result.getInt("class_id");
				String name = result.getString("name");
				String description = result.getString("description");
				String level = result.getString("level");
				int departmentId = result.getInt("department_id");
				
				System.out.println(classId + ", " + name + ", " + description + ", " + level + ", " + departmentId);
			}
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public void getClass(int id) {
		try {
			Connection connection = ConnectionPool.startPool().getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM Classes WHERE class_id = ?");
			statement.setInt(1, id);
			
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				int classId = result.getInt("class_id");
				String name = result.getString("name");
				String description = result.getString("description");
				String level = result.getString("level");
				int departmentId = result.getInt("department_id");
				
				System.out.println(classId + ", " + name + ", " + level + ", " + departmentId);
			}
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public void deleteClass(UniClass uniClass) {
		try {
			Connection connection = ConnectionPool.startPool().getConnection();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM Classes WHERE class_id = ?");
			statement.setInt(1, uniClass.getClassId());
			
			statement.executeUpdate();
			
			System.out.println("Class deleted");
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public void updateClass(UniClass uniClass) {
		try {
			Connection connection = ConnectionPool.startPool().getConnection();
			PreparedStatement statement = connection.prepareStatement("UPDATE Classes SET name = ? WHERE class_id = ?");
			
			statement.setString(1, "Django");
			statement.setInt(2, uniClass.getClassId());
			
			statement.executeUpdate();
			
			System.out.println("Inserted new class into the database");
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public void insertClass(UniClass uniClass) {
		try {
			Connection connection = ConnectionPool.startPool().getConnection();
			PreparedStatement statement = connection.prepareStatement("INSERT INTO Classes (name, description, level, department_id) VALUES (?,?,?,?)");
			
			statement.setString(1, uniClass.getName());
			statement.setString(2, uniClass.getDescription());
			statement.setString(3, uniClass.getLevel());
			statement.setInt(4, uniClass.getDepartmentId());
			
			statement.executeUpdate();
			
			System.out.println("Inserted new class into the database");
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}

}
