package mshantadze.solvd_laba_university.dao.interfaces;

import java.util.List;

import mshantadze.solvd_laba_university.models.Event;

public interface IEventsDAO {
	public List<Event> getEvents();
	public Event getEvent(Event event);
	public void create(Event event);
	public void update(Event event);
	public void delete(Event event);
}
