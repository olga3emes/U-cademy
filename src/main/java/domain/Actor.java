package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import security.UserAccount;

@Entity
@Access(AccessType.PROPERTY)
public abstract class Actor extends DomainEntity{
	
	// Constructores -----------------------------------------------------------
		public Actor() {
			super();
		}

		// Atributos -------------------------------------------------------------
		
		private String name;
		
		private String surname;
		
		private String email;
		
		private String phone;

		private Image picture;
		@NotBlank
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		@NotBlank
		public String getSurname() {
			return surname;
		}

		public void setSurname(String surname) {
			this.surname = surname;
		}
		@Email
		@NotNull
		@NotBlank
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
		@Pattern(regexp = "([9|8|7|6])+[0-9]{8}")
		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		@Valid
		public Image getPicture() {
			return picture;
		}

		public void setPicture(Image picture) {
			this.picture = picture;
		}

		@Transient
		public String getFullName(){
			return getName() + " "+getSurname();
		}

		
		public String toString() {
			return "name=" + name + ", surname=" + surname + ", email="
					+ email + "]";
		}
		 // Relaciones ----------------------------------------------------------

		 private UserAccount userAccount;
		 
		 @NotNull
		 @Valid
		 @OneToOne(cascade=CascadeType.ALL, optional=false)
		 public UserAccount getUserAccount() {
		  return userAccount;
		 }

		 public void setUserAccount(UserAccount userAccount) {
		  this.userAccount = userAccount;
		 }

	
	}
