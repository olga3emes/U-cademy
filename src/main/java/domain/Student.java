package domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)

public class Student extends Actor{
//Constructores
	public Student(){
		super();
		notifications=new ArrayList<Notification>();
		inscriptions=new ArrayList<Inscription>();
		invoices=new ArrayList<Invoice>();
	}
//Atributos
	private String address;
	private Date dateOfBirth;

	
	@NotBlank
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Past
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Transient
	public int getAge() {
		int result=0; 

		Calendar now=Calendar.getInstance(); 
		int year=getDateOfBirth().getYear()+1900;
		int month=getDateOfBirth().getMonth()+1;
		int day=getDateOfBirth().getDate();
		now.add(Calendar.YEAR, -year); 
		now.add(Calendar.MONTH, -month); 
		now.add(Calendar.DAY_OF_MONTH, -day); 

		result=now.get(Calendar.YEAR); 

		return result;
	}


	

//Relaciones
	private Assessment assessment;
	private Academy academy;
	private Collection<Notification> notifications;
	private Collection<Inscription> inscriptions;
	private Collection<Invoice> invoices;
	
	@Valid
	@OneToOne(optional = true,cascade=CascadeType.ALL,mappedBy = "student")
	public Assessment getAssessment() {
		return assessment;
	}
	public void setAssessment(Assessment assessment) {
		this.assessment = assessment;
	}
	
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
	@OneToMany(mappedBy = "student")
	public Collection<Notification> getNotifications() {
		return notifications;
	}
	public void setNotifications(Collection<Notification> notifications) {
		this.notifications = notifications;
	}
	
	@Valid
	@NotNull
	@OneToMany(mappedBy = "student")
	public Collection<Inscription> getInscriptions() {
		return inscriptions;
	}
	public void setInscriptions(Collection<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}
	
	@Valid
	@NotNull
	@OneToMany(mappedBy = "student")
	public Collection<Invoice> getInvoices() {
		return invoices;
	}
	public void setInvoices(Collection<Invoice> invoices) {
		this.invoices = invoices;
	}
	
	
}
