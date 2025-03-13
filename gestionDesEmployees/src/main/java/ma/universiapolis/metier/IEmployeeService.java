package ma.universiapolis.metier;

import java.util.List;

import ma.universiapolis.entities.Contrat;
import ma.universiapolis.entities.Employee;


public interface IEmployeeService {
	
	
	public Employee addEmployee(Employee e);
	public Employee updateEmployee(Employee e,Long id);
	public Employee getEmployeeById(Long id);
	public void deleteEmployee(Long id);
	public List<Employee> getAllEmployee();
	public Employee getEmployeeByContratId(Long id);
	public List<Employee> getEmployeeByDepartementId(Long id);
	public List<Employee> getEmployeesByName(String name);
	public List<Employee> getEmployeeByCin(String cin);

}
