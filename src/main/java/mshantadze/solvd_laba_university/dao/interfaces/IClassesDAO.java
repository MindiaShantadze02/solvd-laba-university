package mshantadze.solvd_laba_university.dao.interfaces;

import mshantadze.solvd_laba_university.models.UniClass;

public interface IClassesDAO {
	public void getClasses();
	public void getClass(int id);
	public void deleteClass(UniClass uniClass);
	public void updateClass(UniClass uniClass);
	public void insertClass(UniClass uniClass);
}
