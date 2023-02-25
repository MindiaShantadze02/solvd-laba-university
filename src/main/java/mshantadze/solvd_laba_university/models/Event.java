package mshantadze.solvd_laba_university.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import mshantadze.solvd_laba_university.parsers.xml.jaxb.utils.DateAdapter;

@XmlType
@XmlRootElement(name="event")
@XmlAccessorType(XmlAccessType.FIELD)
public class Event {
	@XmlAttribute(name="id")
	private int eventId;
	@XmlElement
	private String name;
	@XmlElement
	private String description;
	@XmlElement
	private String organiserId;
	@XmlJavaTypeAdapter(DateAdapter.class)
	private String date;
	
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOrganiserId() {
		return organiserId;
	}
	public void setOrganiserId(String organiserId) {
		this.organiserId = organiserId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
