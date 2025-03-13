package ma.universiapolis.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ma.universiapolis.dao.DepartementDAO;
import ma.universiapolis.dao.EmployeeDAO;
import ma.universiapolis.entities.Contrat;
import ma.universiapolis.entities.Employee;
@Service
@Transactional
public class EmployeeServiceImpl  implements IEmployeeService{

	@Autowired
	private EmployeeDAO edao;
	
	@Override
	public Employee addEmployee(Employee e) {
		return this.edao.save(e);
	}

	@Override
	public Employee updateEmployee(Employee e, Long id) {
		Employee employeDB=getEmployeeById(id);
		employeDB.setCin(e.getCin());
		employeDB.setName(e.getName());
		employeDB.setDateOfBirth(e.getDateOfBirth());
		employeDB.setDepartement(e.getDepartement());
		return this.edao.save(employeDB);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return this.edao.findById(id).orElse(null);
	}

	@Override
	public void deleteEmployee(Long id) {
	if (getEmployeeById(id)!=null) {
			
			this.edao.deleteById(id);
		}
		
	}

	@Override
	public List<Employee> getAllEmployee() {
		return this.edao.findAll();
	}

	@Override
	public Employee getEmployeeByContratId(Long id) {
		return this.edao.findByContratId(id);
	}

	@Override
	public List<Employee> getEmployeeByDepartementId(Long id) {
		return this.edao.findByDepartementId(id);
	}

	@Override
	public List<Employee> getEmployeesByName(String name) {
		return this.edao.findByNameContains(name);
	}

	@Override
	public List<Employee> getEmployeeByCin(String cin) {
		return this.edao.findByCinContains(cin);
	}

}
