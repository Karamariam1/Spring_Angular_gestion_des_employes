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
import ma.universiapolis.metier.IDepartementService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/universiapolis")

public class DepartementController {
	
	@Autowired
	private IDepartementService departementService;
	
	
	@GetMapping("/departement")
	public List<Departement> getDepartementsFromDb(){
		return this.departementService.getAllDepartement();
	}
	
	
	@GetMapping("/departement/{id}")
	public Departement getDepartementByIdFromDb(@PathVariable("id") Long id){
		return this.departementService.getDepartementById(id);
	}
	
	
	@DeleteMapping("/departement/{id}")
	public void deleteDepartementByIdFromDb(@PathVariable("id") Long id){
		 this.departementService.deleteDepartement(id);
	}

	@PostMapping("/departement")
	public Departement addDepartementtoDb(@RequestBody Departement  d){
		return this.departementService.addDepartement(d);
	}
	

	@PutMapping("/departement/{id}")
	public Departement EditDepartementInDb(@RequestBody Departement d,@PathVariable("id") Long id){
		return this.departementService.updateDepartement(d,id);
	}
	
	
	@GetMapping("/searchDepartement/{libelle}")
	public List<Departement> searchForDepartementsByLibelle(@PathVariable("libelle") String libelle){
		return this.departementService.getDepartementsByLibelle(libelle);
	}

}
