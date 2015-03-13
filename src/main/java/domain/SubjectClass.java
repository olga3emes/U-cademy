package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)

public class SubjectClass extends DomainEntity{
//Constructores
	public SubjectClass(){
		super();
	}
//Atributos
	private WeekDay weekDay;
	private Date startHour;
	private Date finishHour;
	
	
	@NotNull
	@Enumerated(EnumType.STRING)
	public WeekDay getWeekDay() {
		return weekDay;
	}
	public void setWeekDay(WeekDay weekDay) {
		this.weekDay = weekDay;
	}
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="HH:mm")
	public Date getStartHour() {
		return startHour;
	}
	public void setStartHour(Date startHour) {
		this.startHour = startHour;
	}
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="HH:mm")
	public Date getFinishHour() {
		return finishHour;
	}
	public void setFinishHour(Date finishHour) {
		this.finishHour = finishHour;
	}
	
	//Relaciones
	private Subject subject;
	private Group group;
	
	@Valid
	@NotNull
	@ManyToOne(optional = false)
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	@Valid
	@NotNull
	@ManyToOne(optional = false)
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}



	
}
