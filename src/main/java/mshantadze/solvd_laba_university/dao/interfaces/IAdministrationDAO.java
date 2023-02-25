package mshantadze.solvd_laba_university.dao.interfaces;

import mshantadze.solvd_laba_university.models.Employee;

public interface IAdministrationDAO {
	public void getEmployees();
	public void getEmployee(String id);
	public void deleteEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void insertEmployee(Employee employee);
}
