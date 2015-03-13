package domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)

public class Folder extends DomainEntity{
//Constructores
	public Folder(){
		super();
		children=new ArrayList<Folder>();
		files=new ArrayList<File>();
	}
//Atributos
	private String name;

	@NotBlank
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	//Relaciones
	private Folder parent;
	private Collection<Folder> children;
	private Collection<File> files;
	private Subject subject;
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	public Folder getParent() {
		return parent;
	}


	public void setParent(Folder parent) {
		this.parent = parent;
	}

	@Valid
	@NotNull
	@OneToMany(mappedBy = "parent")
	public Collection<Folder> getChildren() {
		return children;
	}


	public void setChildren(Collection<Folder> children) {
		this.children = children;
	}

	@Valid
	@NotNull
	@OneToMany(mappedBy = "folder",cascade=CascadeType.ALL)
	public Collection<File> getFiles() {
		return files;
	}


	public void setFiles(Collection<File> files) {
		this.files = files;
	}

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	public Subject getSubject() {
		return subject;
	}


	public void setSubject(Subject subject) {
		this.subject = subject;
	}


}
