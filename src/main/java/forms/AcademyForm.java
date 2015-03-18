package forms;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import domain.Image;

public class AcademyForm {
	
	private int id;
	private String name;
	private MultipartFile multipartFile;
	private String description;
	private String country;
	private String city;
	private String address;
	private int postcode;
	private String phone;
	private String phone2;
	private String fax;
	private String email;
	private double minPrice;
	private double maxPrice;
	private String tags;

	public int getId(){
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@NotBlank
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public String getTags() {
		return tags;
	}


	public void setTags(String tags) {
		this.tags = tags;
	}
	
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}


	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

}
