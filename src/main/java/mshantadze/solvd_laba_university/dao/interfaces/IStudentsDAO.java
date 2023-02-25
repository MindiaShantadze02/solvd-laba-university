package mshantadze.solvd_laba_university.dao.interfaces;

import java.util.ArrayList;

import mshantadze.solvd_laba_university.models.Student;

public interface IStudentsDAO {
	public ArrayList<Student> getStudents();
	public Student getStudent(String id);
	public void deleteStudent(Student Student);
	public void updateStudent(Student student);
	public void insertStudent(Student student);
}
