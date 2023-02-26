package mshantadze.solvd_laba_university.dao.interfaces;

import java.util.List;

import mshantadze.solvd_laba_university.models.Lecturer;

public interface ILecturersDAO {
	public List<Lecturer> getLecturers();
	public Lecturer getLecturer(String id);
	public void deleteLecturer(Lecturer Student);
	public void updateLecturer(Lecturer student);
	public void insertLecturer(Lecturer student);
}
