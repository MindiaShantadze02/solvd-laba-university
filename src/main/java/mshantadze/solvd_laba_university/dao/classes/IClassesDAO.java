package mshantadze.solvd_laba_university.dao.classes;

public interface IClassesDAO {
	public void getClasses();
	public void getClass(int id);
	public void deleteClass(UniClass uniClass);
	public void updateClass(UniClass uniClass);
	public void insertClass(UniClass uniClass);
}
