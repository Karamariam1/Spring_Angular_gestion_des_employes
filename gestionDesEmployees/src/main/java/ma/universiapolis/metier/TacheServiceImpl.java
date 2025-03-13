package ma.universiapolis.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ma.universiapolis.dao.DepartementDAO;
import ma.universiapolis.dao.EmployeeDAO;
import ma.universiapolis.dao.TacheDAO;
import ma.universiapolis.entities.Contrat;
import ma.universiapolis.entities.Employee;
import ma.universiapolis.entities.Tache;
@Service
@Transactional
public class TacheServiceImpl  implements ITacheService{

	
	@Autowired
	private TacheDAO tdao;
	

	@Override
	public Tache addTache(Tache t) {
		
		return this.tdao.save(t);
	}

	@Override
	public Tache updateTache(Tache t,Long id) {
		
		Tache tacheDB=getTacheById(id);
		tacheDB.setDesignation(t.getDesignation());
		tacheDB.setTypeTache(t.getTypeTache());
		tacheDB.setDuree(t.getDuree());
		tacheDB.setEmployees(t.getEmployees());
		return this.tdao.save(tacheDB);
	}

	@Override
	public Tache getTacheById(Long id) {
		
		return this.tdao.findById(id).orElse(null);
	}

	@Override
	public void deleteTache(Long id) {
	if (getTacheById(id)!=null) {
			
			this.tdao.deleteById(id);
		}
		
	}

	@Override
	public List<Tache> getAllTaches() {
		return this.tdao.findAll();
	}

	@Override
	public List<Tache> getTachesByDesignation(String des) {
		return this.tdao.findByDesignationContains(des);
	}

	@Override
	public List<Tache> getTachesByType(String type) {
		return this.tdao.findByTypeTacheContains(type);
	}

	@Override
	public Tache AffecteEmployeesToTache(Tache t, List<Employee> emps) {
		t.setEmployees(emps);
		return t;
	}

}
