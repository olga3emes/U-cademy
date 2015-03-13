package domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Academy extends DomainEntity{
	
	// Constructores -----------------------------------------------------------
		public Academy() {
			super();
			professors=new ArrayList<Professor>();
			students=new ArrayList<Student>();
			assessments=new ArrayList<Assessment>();
			payments=new ArrayList<Payment>();
		}

		// Atributos -------------------------------------------------------------
		
		private String name;
		private Image image;
		private String description;
		private String country;
		private String city;
		private String address;
		private int postcode;
		private String phone;
		private String phone2;
		private String fax;
		private String email;
		private Location location;
		private boolean isPremium;
		private double minPrice;
		private double maxPrice;
		private String[] tags;

		@NotBlank
		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}

		@Valid
		public Image getImage() {
			return image;
		}


		public void setImage(Image image) {
			this.image = image;
		}

		@NotBlank
		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}

		@NotBlank
		public String getCountry() {
			return country;
		}


		public void setCountry(String country) {
			this.country = country;
		}

		@NotBlank
		public String getCity() {
			return city;
		}


		public void setCity(String city) {
			this.city = city;
		}

		@NotBlank
		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		public int getPostcode() {
			return postcode;
		}


		public void setPostcode(int postcode) {
			this.postcode = postcode;
		}

		@Pattern(regexp = "([9|8|7|6])+[0-9]{8}")
		public String getPhone() {
			return phone;
		}


		public void setPhone(String phone) {
			this.phone = phone;
		}

		@Pattern(regexp = "([9|8|7|6])+[0-9]{8}")
		public String getPhone2() {
			return phone2;
		}


		public void setPhone2(String phone2) {
			this.phone2 = phone2;
		}


		public String getFax() {
			return fax;
		}


		public void setFax(String fax) {
			this.fax = fax;
		}

		@NotBlank
		@Email
		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}

		@NotNull
		@Valid
		public Location getLocation() {
			return location;
		}


		public void setLocation(Location location) {
			this.location = location;
		}


		public boolean isPremium() {
			return isPremium;
		}


		public void setPremium(boolean isPremium) {
			this.isPremium = isPremium;
		}

		@Min(0)
		@Digits(integer=10, fraction=2)
		public double getMinPrice() {
			return minPrice;
		}


		public void setMinPrice(double minPrice) {
			this.minPrice = minPrice;
		}

		@Min(0)
		@Digits(integer=10, fraction=2)
		public double getMaxPrice() {
			return maxPrice;
		}


		public void setMaxPrice(double maxPrice) {
			this.maxPrice = maxPrice;
		}


		public String[] getTags() {
			return tags;
		}


		public void setTags(String[] tags) {
			this.tags = tags;
		}


		 // Relaciones ----------------------------------------------------------
		private Owner owner;
		private Collection<Professor> professors;
		private Collection<Student> students;
		private Collection<Assessment> assessments;
		private Collection<Payment> payments;
		
		@Valid
		@NotNull
		@ManyToOne(optional = false)
		public Owner getOwner() {
			return owner;
		}


		public void setOwner(Owner owner) {
			this.owner = owner;
		}

		@Valid
		@NotNull
		@OneToMany(mappedBy = "academy")
		public Collection<Professor> getProfessors() {
			return professors;
		}


		public void setProfessors(Collection<Professor> professors) {
			this.professors = professors;
		}

		@Valid
		@NotNull
		@OneToMany(mappedBy = "academy")
		public Collection<Student> getStudents() {
			return students;
		}


		public void setStudents(Collection<Student> students) {
			this.students = students;
		}

		@Valid
		@NotNull
		@OneToMany(mappedBy = "academy")
		public Collection<Assessment> getAssessments() {
			return assessments;
		}


		public void setAssessments(Collection<Assessment> assessments) {
			this.assessments = assessments;
		}

		@Valid
		@NotNull
		@OneToMany(mappedBy = "academy")
		public Collection<Payment> getPayments() {
			return payments;
		}


		public void setPayments(Collection<Payment> payments) {
			this.payments = payments;
		}


		
		
	
	}
