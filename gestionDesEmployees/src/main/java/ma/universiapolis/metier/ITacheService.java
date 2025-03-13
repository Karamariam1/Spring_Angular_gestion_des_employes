package ma.universiapolis.metier;

import java.util.List;

import ma.universiapolis.entities.Contrat;
import ma.universiapolis.entities.Employee;
import ma.universiapolis.entities.Tache;


public interface ITacheService {
	
	
	public Tache addTache(Tache t);
	public Tache updateTache(Tache t,Long id);
	public Tache getTacheById(Long id);
	public void deleteTache(Long id);
	public List<Tache> getAllTaches();
	public List<Tache> getTachesByDesignation(String des);
	public List<Tache> getTachesByType(String type);
	public Tache AffecteEmployeesToTache(Tache t,List<Employee> emps);
	

}
