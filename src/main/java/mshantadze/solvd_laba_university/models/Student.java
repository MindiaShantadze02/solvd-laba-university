package mshantadze.solvd_laba_university.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonProperty;

import mshantadze.solvd_laba_university.Gender;
import mshantadze.solvd_laba_university.parsers.xml.jaxb.utils.DateAdapter;

@XmlType
@XmlRootElement(name="student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
	@XmlAttribute(name="id", required = true)
	@JsonProperty("id")
	private String studentId;
	@JsonProperty("firstName")
	@XmlElement
	private String firstName;
	@JsonProperty("lastName")
	@XmlElement
	private String lastName;
	@JsonProperty("phoneNumber")
	@XmlElement
	private String phoneNumber;
	@JsonProperty("active")
	@XmlElement
	private boolean active;
	@JsonProperty("gender")
	@XmlElement
	private Gender gender;
	@JsonProperty("level")
	@XmlElement
	private String level;
	@JsonProperty("birthDate")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private String birthDate;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String studentId, String firstName, String lastName, String phoneNumber, boolean active,
		Gender gender, String level, String birthDate) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.active = active;
		this.gender = gender;
		this.level = level;
		this.birthDate = birthDate;
	}

	public String getStudentId() {
		return studentId;
	}


	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = Gender.getGender(gender);
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	public String getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	
}
