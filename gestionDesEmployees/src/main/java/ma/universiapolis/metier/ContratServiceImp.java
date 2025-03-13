package ma.universiapolis.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ma.universiapolis.dao.ContratDAO;
import ma.universiapolis.dao.DepartementDAO;
import ma.universiapolis.entities.Contrat;
import ma.universiapolis.entities.Departement;

@Service
@Transactional
public class ContratServiceImp  implements 	IContratService{

	
	@Autowired
	private ContratDAO cdao;

	@Override
	public Contrat addContrat(Contrat c) {
	
		return this.cdao.save(c);
	}

	@Override
	public Contrat updateContrat(Contrat c, Long id) {
		Contrat contratDB=getContratById(id);
		contratDB.setReference(c.getReference());
		contratDB.setType(c.getType());
		contratDB.setDateDebut(c.getDateDebut());
		contratDB.setDateFin(c.getDateFin());
		contratDB.setEmployee(c.getEmployee());
		return this.cdao.save(contratDB);
	}

	@Override
	public Contrat getContratById(Long id) {
		return this.cdao.findById(id).orElse(null);
	}

	@Override
	public void deleteContrat(Long id) {
	if (getContratById(id)!=null) {
			
			this.cdao.deleteById(id);
		}
		
	}

	@Override
	public List<Contrat> getAllContrat() {
		
		return this.cdao.findAll();
	}

	@Override
	public Contrat getContratByEmployeeId(Long id) {

		return this.cdao.findByEmployeeId(id);
	}

	@Override
	public List<Contrat> getContratsByType(String type) {
		return this.cdao.findByType(type);
	}

	@Override
	public Contrat getContratByReference(String reference) {
		return this.cdao.findByReference(reference);
	}

}
