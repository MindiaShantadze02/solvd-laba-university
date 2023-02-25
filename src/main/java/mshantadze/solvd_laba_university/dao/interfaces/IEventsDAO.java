package mshantadze.solvd_laba_university.dao.interfaces;

import mshantadze.solvd_laba_university.models.Event;

public interface IEventsDAO {
	public void getEvents();
	public void getEvent();
	public void create(Event event);
	public void update(Event event);
	public void delete(Event event);
}
