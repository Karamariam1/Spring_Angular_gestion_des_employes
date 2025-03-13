package ma.universiapolis.metier;

import java.util.List;

import ma.universiapolis.entities.Contrat;


public interface IContratService {
	
	
	public Contrat addContrat(Contrat c);
	public Contrat updateContrat(Contrat c,Long id);
	public Contrat getContratById(Long id);
	public void deleteContrat(Long id);
	public List<Contrat> getAllContrat();
	public Contrat getContratByEmployeeId(Long id);
	public List<Contrat> getContratsByType(String type);
	public Contrat getContratByReference(String reference);

}
