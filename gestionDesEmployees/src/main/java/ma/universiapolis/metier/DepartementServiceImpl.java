package ma.universiapolis.metier;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ma.universiapolis.dao.DepartementDAO;
import ma.universiapolis.entities.Departement;
@Service
@Transactional
public class DepartementServiceImpl  implements IDepartementService{

	@Autowired
	private DepartementDAO ddao;
	
	@Override
	public Departement addDepartement(Departement d) {
		// TODO Auto-generated method stub
		return this.ddao.save(d);
	}

	@Override
	public Departement updateDepartement(Departement d,Long id) {
		Departement dDb=getDepartementById(id);
		dDb.setLibelle(d.getLibelle());
		return this.ddao.save(dDb);
	}

	@Override
	public Departement getDepartementById(Long id) {
		
		return this.ddao.findById(id).orElse(null);
	}

	@Override
	public void deleteDepartement(Long id) {
		if (getDepartementById(id)!=null) {
			
			this.ddao.deleteById(id);
		}
		
	}

	@Override
	public List<Departement> getAllDepartement() {
	
		
		return this.ddao.findAll();
	}

	@Override
	public List<Departement> getDepartementsByLibelle(String libelle) {
		return this.ddao.findByLibelleContains(libelle);
	}

}
