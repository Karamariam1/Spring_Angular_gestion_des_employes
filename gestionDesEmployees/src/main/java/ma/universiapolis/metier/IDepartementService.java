package ma.universiapolis.metier;

import java.util.List;


import ma.universiapolis.entities.Departement;

public interface IDepartementService {
	
	
	public Departement addDepartement(Departement d);
	public Departement updateDepartement(Departement d,Long id);
	public Departement getDepartementById(Long id);
	public void deleteDepartement(Long id);
	public List<Departement> getAllDepartement();
	public List<Departement> getDepartementsByLibelle(String libelle);

}
