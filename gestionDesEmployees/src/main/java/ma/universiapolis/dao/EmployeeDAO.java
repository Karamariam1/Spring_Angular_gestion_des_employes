package ma.universiapolis.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import ma.universiapolis.entities.Contrat;
import ma.universiapolis.entities.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Long>{
	public List<Employee>  findByCinContains(String cin);
	public List<Employee> findByNameContains(String name);
	public Employee findByContratId(Long id);
	public List<Employee> findByDepartementId(Long id);
	
	
}
