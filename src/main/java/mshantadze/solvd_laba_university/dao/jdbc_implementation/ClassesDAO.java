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
import mshantadze.solvd_laba_university.dao.interfaces.IClassesDAO;
import mshantadze.solvd_laba_university.models.UniClass;

public class ClassesDAO implements IClassesDAO {
	private static final Logger LOGGER = LogManager.getLogger(StudentsDAO.class);
	
	@Override
	public List<UniClass> getClasses() {
		UniClass uniClass = null;
		List<UniClass> uniClasses = new ArrayList<>();
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
				
				uniClass = new UniClass(classId, name, description, level, departmentId);
				uniClasses.add(uniClass);
			}
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e.getMessage());
		}
		
		return uniClasses;
	}

	@Override
	public UniClass getClass(int id) {
		UniClass uniClass = null;
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
				
				uniClass = new UniClass(classId, name, description, level, departmentId);
			}
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e.getMessage());
		}
		
		return uniClass;
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
