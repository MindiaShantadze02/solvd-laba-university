package mshantadze.solvd_laba_university.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonProperty;

import mshantadze.solvd_laba_university.parsers.xml.jaxb.utils.DateAdapter;


@XmlType
@XmlRootElement(name="lecturer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Lecturer {
	@XmlAttribute(name="id")
	@JsonProperty("id")
	private String employeeId;
	
	@XmlElement
	@JsonProperty("firstName")
	private String firstName;
	
	@XmlElement
	@JsonProperty("lastName")
	private String lastName;
	
	@XmlElement
	@JsonProperty("phoneNumber")
	private String phoneNumber;
	
	@XmlElement
	@JsonProperty("active")
	private boolean active;
	
	@XmlElement
	@JsonProperty("gender")
	private String gender;
	
	private String photo;
	
	@XmlElement
	@JsonProperty("departmentId")
	private int departmentId;
	
	@XmlElement
	@JsonProperty("classId")
	
	private int classId;
	
	@XmlJavaTypeAdapter(DateAdapter.class)
	@JsonProperty("birthDate")
	private String birthDate;

	public Lecturer() {
		super();
	}

	public Lecturer(String employeeId, String firstName, String lastName, String phoneNumber, boolean active,
			String gender, String photo, int departmentId, int classId, String birthDate) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.active = active;
		this.gender = gender;
		this.photo = photo;
		this.departmentId = departmentId;
		this.classId = classId;
		this.birthDate = birthDate;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}
}
