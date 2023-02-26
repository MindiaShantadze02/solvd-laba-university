package mshantadze.solvd_laba_university.dao.interfaces;

import java.util.List;

import mshantadze.solvd_laba_university.models.Employee;

public interface IAdministrationDAO {
	public List<Employee> getEmployees();
	public Employee getEmployee(String id);
	public void deleteEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void insertEmployee(Employee employee);
}
