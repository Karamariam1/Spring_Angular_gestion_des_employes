package ma.universiapolis.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Employee {
		
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cin;
	private String name;
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	
	
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private Departement departement;

	
	
	
	
	
	
	@OneToOne(mappedBy = "employee")

	private Contrat contrat;
	
	@ManyToMany(mappedBy = "employees")
	@JsonIgnore
	private List<Tache> taches;

}
