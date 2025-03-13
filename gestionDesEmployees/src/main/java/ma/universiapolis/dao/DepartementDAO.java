package ma.universiapolis.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import ma.universiapolis.entities.Departement;




public interface DepartementDAO extends JpaRepository<Departement, Long>{
	public List<Departement> findByLibelleContains(String libelle);
}
