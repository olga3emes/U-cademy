package domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)

public class Subject extends DomainEntity{
//Constructores
	public Subject(){
		super();
		professors=new ArrayList<Professor>();
		inscriptions=new ArrayList<Inscription>();
		folders=new ArrayList<Folder>();
		subjectClasses=new ArrayList<SubjectClass>();
	}
//Atributos
	private String name;
	private String level;
	private double price;
	
	@Min(0)
	@Digits(integer=10, fraction=2)
	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}
	
	@NotBlank
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}
	//Relaciones
	private Collection<Professor> professors;
	private Collection<Inscription> inscriptions;
	private Collection<Folder> folders;
	private Collection<SubjectClass> subjectClasses;
	@Valid
	@NotNull
	@ManyToMany()
	public Collection<Professor> getProfessors() {
		return professors;
	}
	public void setProfessors(Collection<Professor> professors) {
		this.professors = professors;
	}

	
	@Valid
	@NotNull
	@OneToMany(mappedBy = "subject")
	public Collection<Inscription> getInscriptions() {
		return inscriptions;
	}
	public void setInscriptions(Collection<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}
	
	@Valid
	@NotNull
	@OneToMany(mappedBy = "subject")
	public Collection<Folder> getFolders() {
		return folders;
	}
	public void setFolders(Collection<Folder> folders) {
		this.folders = folders;
	}
	
	@Valid
	@NotNull
	@OneToMany(mappedBy = "subject")
	public Collection<SubjectClass> getSubjectClasses() {
		return subjectClasses;
	}
	public void setSubjectClasses(Collection<SubjectClass> subjectClasses) {
		this.subjectClasses = subjectClasses;
	}

	
}
