package mshantadze.solvd_laba_university.dao.interfaces;

import java.util.List;

import mshantadze.solvd_laba_university.models.UniClass;

public interface IClassesDAO {
	public List<UniClass> getClasses();
	public UniClass getClass(int id);
	public void deleteClass(UniClass uniClass);
	public void updateClass(UniClass uniClass);
	public void insertClass(UniClass uniClass);
}
