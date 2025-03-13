package ma.universiapolis.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import ma.universiapolis.entities.Contrat;
import ma.universiapolis.entities.Employee;
import ma.universiapolis.entities.Tache;


public interface TacheDAO extends JpaRepository<Tache, Long>{

	public List<Tache>  findByDesignationContains(String des);
	public List<Tache> findByTypeTacheContains(String type);

}
