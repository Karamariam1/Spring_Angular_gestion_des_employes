package ma.universiapolis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ma.universiapolis.entities.Departement;
import ma.universiapolis.entities.Employee;
import ma.universiapolis.metier.IDepartementService;
import ma.universiapolis.metier.IEmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/universiapolis")

public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	
	@GetMapping("/employee")
	public List<Employee> getEmployeesFromDb(){
		return this.employeeService.getAllEmployee();
	}
	
	
	@GetMapping("/employee/{id}")
	public Employee getEmployeeByIdFromDb(@PathVariable("id") Long id){
		return this.employeeService.getEmployeeById(id);
	}
	
	
	@DeleteMapping("/employee/{id}")
	public void deleteEmployeeByIdFromDb(@PathVariable("id") Long id){
		 this.employeeService.deleteEmployee(id);
	}

	@PostMapping("/employee")
	public Employee addEmployeetoDb(@RequestBody Employee e){
		return this.employeeService.addEmployee(e);
	}
	

	@PutMapping("/employee/{id}")
	public Employee EditEmployeeInDb(@RequestBody Employee e,@PathVariable("id") Long id){
		return this.employeeService.updateEmployee(e,id);
	}
	
	
	@GetMapping("/searchEmployeeName/{name}")
	public List<Employee> searchForEmployeesByName(@PathVariable("name") String name){
		return this.employeeService.getEmployeesByName(name);
	}
	
	@GetMapping("/searchEmployeeCin/{cin}")
	public List<Employee> searchForEmployeesByCin(@PathVariable("cin") String cin){
		return this.employeeService.getEmployeeByCin(cin);
	}
	
	@GetMapping("/departement/{id}/employee")
	public List<Employee> getEmployeesByDepartementId(@PathVariable("id") Long id){
		return this.employeeService.getEmployeeByDepartementId(id);
	}
	
	@GetMapping("/contrat/{id}/employee")
	public Employee getEmployeesByContratId(@PathVariable("id") Long id){
		return this.employeeService.getEmployeeByContratId(id);
	}
	
	


}
