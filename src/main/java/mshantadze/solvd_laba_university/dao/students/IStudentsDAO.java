package mshantadze.solvd_laba_university.dao.students;

import java.util.ArrayList;

public interface IStudentsDAO {
	public ArrayList<Student> getStudents();
	public Student getStudent(String id);
	public void deleteStudent(Student Student);
	public void updateStudent(Student student);
	public void insertStudent(Student student);
}
