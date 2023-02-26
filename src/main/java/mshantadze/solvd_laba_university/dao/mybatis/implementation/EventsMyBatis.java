package mshantadze.solvd_laba_university.dao.mybatis.implementation;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mshantadze.solvd_laba_university.dao.interfaces.IEventsDAO;
import mshantadze.solvd_laba_university.dao.mybatis.MyBatis;
import mshantadze.solvd_laba_university.models.Event;

public class EventsMyBatis extends MyBatis implements IEventsDAO {
	private static final Logger LOGGER = LogManager.getLogger(EventsMyBatis.class);

	@Override
	public List<Event> getEvents() {
		SqlSession session = factory.openSession();
		List<Event> events = new ArrayList<>();
        try{
        	IEventsDAO iEventsDAO = session.getMapper(IEventsDAO.class);
        	events = iEventsDAO.getEvents();
        } catch(Exception e) {
            session.rollback();
        	LOGGER.error(e);
        }
        finally {
            session.close();
        }
        
        return events;
	}

	@Override
	public Event getEvent(Event eventArg) {
		SqlSession session = factory.openSession();
		Event event = null;
        try{
        	IEventsDAO iEventsDAO = session.getMapper(IEventsDAO.class);
        	event = iEventsDAO.getEvent(event);
        } catch(Exception e) {
            session.rollback();
        	LOGGER.error(e);
        }
        finally {
            session.close();
        }
        
        return event;
	}

	@Override
	public void create(Event event) {
		SqlSession session = factory.openSession();
        try{
        	IEventsDAO iEventsDAO = session.getMapper(IEventsDAO.class);
        	iEventsDAO.create(event);
        } catch(Exception e) {
            session.rollback();
        	LOGGER.error(e);
        }
        finally {
            session.close();
        }
	}

	@Override
	public void update(Event event) {
		SqlSession session = factory.openSession();
        try{
        	IEventsDAO iEventsDAO = session.getMapper(IEventsDAO.class);
        	iEventsDAO.update(event);
        } catch(Exception e) {
            session.rollback();
        	LOGGER.error(e);
        }
        finally {
            session.close();
        }
	}

	@Override
	public void delete(Event event) {
		SqlSession session = factory.openSession();
        try{
        	IEventsDAO iEventsDAO = session.getMapper(IEventsDAO.class);
        	iEventsDAO.delete(event);
        } catch(Exception e) {
            session.rollback();
        	LOGGER.error(e);
        }
        finally {
            session.close();
        }
	}
}
