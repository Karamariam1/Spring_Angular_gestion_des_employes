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

import ma.universiapolis.entities.Contrat;
import ma.universiapolis.entities.Departement;
import ma.universiapolis.entities.Employee;
import ma.universiapolis.metier.IContratService;
import ma.universiapolis.metier.IDepartementService;
import ma.universiapolis.metier.IEmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/universiapolis")

public class ContratController {
	
	@Autowired
	private IContratService contratService;
	
	
	@GetMapping("/contrat")
	public List<Contrat> getContratsFromDb(){
		return this.contratService.getAllContrat();
	}
	
	
	@GetMapping("/contrat/{id}")
	public Contrat getContratByIdFromDb(@PathVariable("id") Long id){
		return this.contratService.getContratById(id);
	}
	
	
	@DeleteMapping("/contrat/{id}")
	public void deleteContratByIdFromDb(@PathVariable("id") Long id){
		 this.contratService.deleteContrat(id);
	}

	@PostMapping("/contrat")
	public Contrat addContrattoDb(@RequestBody Contrat c){
		return this.contratService.addContrat(c);
	}
	

	@PutMapping("/contrat/{id}")
	public Contrat EditContratInDb(@RequestBody Contrat c,@PathVariable("id") Long id){
		return this.contratService.updateContrat(c,id);
	}
	
	
	@GetMapping("/searchContratReference/{ref}")
	public Contrat searchForContratByReference(@PathVariable("ref") String ref){
		return this.contratService.getContratByReference(ref);
	}
	
	@GetMapping("/searchContratType/{type}")
	public List<Contrat> searchForContratByType(@PathVariable("type") String type){
		return this.contratService.getContratsByType(type);
	}
	
	@GetMapping("/employee/{id}/contrat")
	public Contrat getContratByEmployeeId(@PathVariable("id") Long id){
		return this.contratService.getContratByEmployeeId(id);
	}
	

	


}
