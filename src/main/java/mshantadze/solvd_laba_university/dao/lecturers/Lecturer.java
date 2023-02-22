package mshantadze.solvd_laba_university.dao.lecturers;

import mshantadze.solvd_laba_university.Gender;

public class Lecturer {
	private String employeeId;
	private String firstName;
	private String lastName;
	private String role;
	private String phoneNumber;
	private boolean active;
	private Gender gender;
	private String photo;
	private int departmentId;
	private String birthDate;
	
	public Lecturer(String employeeId, String firstName, String lastName, String role, String phoneNumber,
		Gender gender, String photo, String birthDate, int departmentId) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.photo = photo;
		this.birthDate = birthDate;
		this.departmentId = departmentId;
		
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public void setGender(Gender gender) {
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
}
