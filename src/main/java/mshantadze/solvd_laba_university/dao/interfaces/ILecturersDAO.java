package mshantadze.solvd_laba_university.dao.interfaces;

import java.util.ArrayList;

import mshantadze.solvd_laba_university.models.Lecturer;

public interface ILecturersDAO {
	public void getLecturers();
	public void getLecturer(String id);
	public void deleteLecturer(Lecturer Student);
	public void updateLecturer(Lecturer student);
	public void insertLecturer(Lecturer student);
}
