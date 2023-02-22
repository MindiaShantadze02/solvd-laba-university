package mshantadze.solvd_laba_university.dao.lecturers;

import java.util.ArrayList;

public interface ILecturersDAO {
	public void getLecturers();
	public void getLecturer(String id);
	public void deleteLecturer(Lecturer Student);
	public void updateLecturer(Lecturer student);
	public void insertLecturer(Lecturer student);
}
