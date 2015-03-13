package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Assessment extends DomainEntity{
	
	// Constructores -----------------------------------------------------------
		public Assessment() {
			super();
		}

		// Atributos -------------------------------------------------------------
		
		private Date assessmentDate;
		private double assessment;
		
		@Past
		@NotNull
		@Temporal(TemporalType.DATE)
		@DateTimeFormat(pattern="dd/MM/yyyy")
		public Date getAssessmentDate() {
			return assessmentDate;
		}


		public void setAssessmentDate(Date assessmentDate) {
			this.assessmentDate = assessmentDate;
		}

		@Range(min = 0, max = 5)
		public double getAssessment() {
			return assessment;
		}


		public void setAssessment(double assessment) {
			this.assessment = assessment;
		}


		// Relaciones ----------------------------------------------------------
		private Academy academy;
		private Student student;
		
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
		@OneToOne(optional = false)
		public Student getStudent() {
			return student;
		}


		public void setStudent(Student student) {
			this.student = student;
		}
		
	
	}
