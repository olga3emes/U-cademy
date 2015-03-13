package domain;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Payment extends DomainEntity{
	
	// Constructores -----------------------------------------------------------
		public Payment() {
			super();
		}

		// Atributos -------------------------------------------------------------
		
		private Date creationDate;
		private double price;
		private boolean paid;

		@Past
		@NotNull
		@Temporal(TemporalType.DATE)
		@DateTimeFormat(pattern="dd/MM/yyyy")
		public Date getCreationDate() {
			return creationDate;
		}


		public void setCreationDate(Date creationDate) {
			this.creationDate = creationDate;
		}
		
		@Min(0)
		@Digits(integer=10, fraction=2)
		public double getPrice() {
			return price;
		}


		public void setPrice(double price) {
			this.price = price;
		}


		public boolean isPaid() {
			return paid;
		}


		public void setPaid(boolean paid) {
			this.paid = paid;
		}

		@Transient
		public Date expirationDate(){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(getCreationDate()); 
			calendar.add(Calendar.DAY_OF_YEAR, 30);
			return calendar.getTime();
		}
		// Relaciones ----------------------------------------------------------
		private Academy academy;
		
		@Valid
		@NotNull
		@ManyToOne(optional = false)
		public Academy getAcademy() {
			return academy;
		}


		public void setAcademy(Academy academy) {
			this.academy = academy;
		}
		
	
	}
