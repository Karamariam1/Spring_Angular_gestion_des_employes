package ma.universiapolis.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import ma.universiapolis.entities.Contrat;


public interface ContratDAO extends JpaRepository<Contrat, Long>{

	
	public Contrat findByEmployeeId(Long id);
	public Contrat findByReference(String reference);
	public List<Contrat> findByType(String type);
}
