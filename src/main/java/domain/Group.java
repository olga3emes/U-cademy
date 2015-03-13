package domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
@Table(name="_Group")
public class Group extends DomainEntity{
//Constructores
	public Group(){
		super();
		subjectClasses=new ArrayList<SubjectClass>();
	}
//Atributos
	private String name;
	private String room;
	private Date startDate;
	private Date finishDate;
	
	@NotBlank
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}

	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	//Relaciones
	private Collection<SubjectClass> subjectClasses;
	private Academy academy;

	@Valid
	@NotNull
	@OneToMany(mappedBy = "group")
	public Collection<SubjectClass> getSubjectClasses() {
		return subjectClasses;
	}
	public void setSubjectClasses(Collection<SubjectClass> subjectClasses) {
		this.subjectClasses = subjectClasses;
	}
	
	@NotNull
	@Valid
	@ManyToOne(optional=false)
	public Academy getAcademy(){
		return academy;
	}
	public void setAcademy(Academy academy){
		this.academy=academy;
	}


	
}
