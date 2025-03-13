package ma.universiapolis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.universiapolis.dao.ContratDAO;
import ma.universiapolis.dao.DepartementDAO;
import ma.universiapolis.dao.EmployeeDAO;
import ma.universiapolis.dao.TacheDAO;
import ma.universiapolis.entities.Contrat;
import ma.universiapolis.entities.Departement;
import ma.universiapolis.entities.Employee;
import ma.universiapolis.entities.Tache;

@SpringBootApplication
public class GestionDesEmployeesApplication  implements CommandLineRunner{

	@Autowired
	private DepartementDAO ddao;
	

	@Autowired
	private ContratDAO cdao;

	@Autowired
	private EmployeeDAO edao;
	
	@Autowired
	private TacheDAO tdao;
	
	
	public static void main(String[] args) {
		SpringApplication.run(GestionDesEmployeesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Departement d1=new Departement(null,"Informatique",null);
		Departement d2=new Departement(null,"Marketing",null);
		Departement d3=new Departement(null,"Finance",null);
		this.ddao.save(d1);
		this.ddao.save(d2);
		this.ddao.save(d3);
		
		Employee e1=new Employee(null,"SH12458","MOHAMED ANDALOUSSI",new Date(),d3,null,null);
		Employee e2=new Employee(null,"FA25487","OUMAIMA IDRRISSI",new Date(),d1,null,null);
		Employee e3=new Employee(null,"SH145868","ILYASS AHMADI",new Date(),d2,null,null);
		Employee e4=new Employee(null,"SH258758","JAMILA ALAOUI",new Date(),d3,null,null);
		Employee e5=new Employee(null,"SH156978","IKRAME TOUBALI",new Date(),d3,null,null);
		List<Employee> allEmp=new ArrayList<Employee>();
		allEmp.add(e1);
		allEmp.add(e2);
		allEmp.add(e3);
		allEmp.add(e4);
		allEmp.add(e5);
		this.edao.saveAll(allEmp);
		
		Contrat c1=new Contrat(null,"RC21548","CDI",new Date(),new Date(),e1);
		Contrat c2=new Contrat(null,"RC458726","CDD",new Date(),new Date(),e2);
		Contrat c3=new Contrat(null,"RC458795","Stage",new Date(),new Date(),e3);
		this.cdao.save(c1);
		this.cdao.save(c2);
		this.cdao.save(c3);
		
	
	
		
		
		List<Employee> employesAffectee= new ArrayList<Employee>();
		employesAffectee.add(e1);
		employesAffectee.add(e2);
		employesAffectee.add(e5);
		
		Tache t1=new Tache(null,"Benchmarkin digital marketing tools","Normele",4,employesAffectee);
		this.tdao.save(t1);
		
		
		
		
	
		
		

		
		
		
	}


}
