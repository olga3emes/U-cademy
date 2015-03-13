package domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class Professor extends Actor{
//Constructores
	public Professor(){
		super();
		notifications=new ArrayList<Notification>();
		subjects=new ArrayList<Subject>();
	}
//Atributos
	private String skills;
	
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}

	
	
//Relaciones
	private Academy academy;
	private Collection<Notification> notifications;
	private Collection<Subject> subjects;
	
	@Valid
	@NotNull
	@ManyToOne(optional = false)
	public Academy getAcademy() {
		return academy;
	}
	public void setAcademy(Academy academy) {
		this.academy = academy;
	}
	
	@Valid
	@NotNull
	@OneToMany(mappedBy = "professor")
	public Collection<Notification> getNotifications() {
		return notifications;
	}
	public void setNotifications(Collection<Notification> notifications) {
		this.notifications = notifications;
	}
	
	@Valid
	@NotNull
	@ManyToMany(mappedBy = "professors")
	public Collection<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(Collection<Subject> subjects) {
		this.subjects = subjects;
	}
}
