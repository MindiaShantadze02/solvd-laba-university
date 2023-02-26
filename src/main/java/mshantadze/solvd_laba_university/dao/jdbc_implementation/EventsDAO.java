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
import mshantadze.solvd_laba_university.dao.interfaces.IEventsDAO;
import mshantadze.solvd_laba_university.models.Event;

public class EventsDAO implements IEventsDAO {
	private static final Logger LOGGER = LogManager.getLogger(EventsDAO.class);
	
	@Override
	public List<Event> getEvents() {
		List<Event> events = new ArrayList<>();
		try {
			Connection connection = ConnectionPool.startPool().getConnection();
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM Events");
			
			while (result.next()) {
				Event event = new Event();
				event.setEventId(result.getInt("event_id"));
				event.setName(result.getString("name"));
				event.setDescription(result.getString("description"));
				event.setDate(result.getString("date"));
				event.setOrganiserId(result.getString("organiser_id"));
				
				events.add(event);
			}
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e);
		}
		
		return events;
	}

	@Override
	public Event getEvent(Event eventArg) {
		Event event = new Event();
		try {
			Connection connection = ConnectionPool.startPool().getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM Events WHERE event_id = ?");
			statement.setInt(1, eventArg.getEventId());
			
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				event.setEventId(result.getInt("event_id"));
				event.setName(result.getString("name"));
				event.setDescription(result.getString("description"));
				event.setDate(result.getString("date"));
				event.setOrganiserId(result.getString("organiser_id"));
			}
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e);
		}
		
		return event;
	}

	@Override
	public void create(Event event) {
		try {
			Connection connection = ConnectionPool.startPool().getConnection();
			PreparedStatement statement = connection.prepareStatement("INSERT INTO Classes (event_id, name, description, organiser_id, date) VALUES (?, ?, ?, ?, ?)");

			statement.setInt(1, event.getEventId());
			statement.setString(2, event.getName());
			statement.setString(3, event.getDescription());
			statement.setString(4, event.getOrganiserId());
			statement.setString(5, event.getDate());
			
			statement.executeUpdate();
			
			LOGGER.info("Inserted new event into the database");
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public void update(Event event) {
		try {
			Connection connection = ConnectionPool.startPool().getConnection();
			PreparedStatement statement = connection.prepareStatement("UPDATE Events SET name = ? WHERE event_id = ?");
			
			statement.setString(1, event.getName());
			statement.setInt(2, event.getEventId());

			statement.executeUpdate();
			
			LOGGER.info("Updated event into the database");
			
			ConnectionPool.releaseConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Event event) {
		try {
			Connection connection = ConnectionPool.startPool().getConnection();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM Events WHERE event_id = ?");

			statement.setInt(1, event.getEventId());
			
			statement.executeUpdate();
			
			LOGGER.info("Deleted event from the database");
			
			ConnectionPool.releaseConnection(connection);
		} catch(SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}
	
}
