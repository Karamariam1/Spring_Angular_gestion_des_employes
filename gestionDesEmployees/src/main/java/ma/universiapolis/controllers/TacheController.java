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
import ma.universiapolis.entities.Tache;
import ma.universiapolis.metier.IDepartementService;
import ma.universiapolis.metier.IEmployeeService;
import ma.universiapolis.metier.ITacheService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/universiapolis")

public class TacheController {
	
	@Autowired
	private ITacheService tacheService;
	
	
	@GetMapping("/tache")
	public List<Tache> getTachesFromDb(){
		return this.tacheService.getAllTaches();
	}
	
	
	@GetMapping("/tache/{id}")
	public Tache getTacheByIdFromDb(@PathVariable("id") Long id){
		return this.tacheService.getTacheById(id);
	}
	
	
	@DeleteMapping("/tache/{id}")
	public void deleteTacheByIdFromDb(@PathVariable("id") Long id){
		 this.tacheService.deleteTache(id);
	}

	@PostMapping("/tache")
	public Tache addTachetoDb(@RequestBody Tache t){
		return this.tacheService.addTache(t);
	}
	

	@PutMapping("/tache/{id}")
	public Tache EditEmployeeInDb(@RequestBody Tache t,@PathVariable("id") Long id){
		return this.tacheService.updateTache(t, id);
	}
	
	
	@GetMapping("/searchTacheDesignation/{des}")
	public List<Tache> searchForTachesByDesignation(@PathVariable("des") String des){
		return this.tacheService.getTachesByDesignation(des);
	}
	
	@GetMapping("/searchTacheType/{type}")
	public List<Tache> searchForTachesByType(@PathVariable("type") String type){
		return this.tacheService.getTachesByType(type);
	}
	

	
	


}
