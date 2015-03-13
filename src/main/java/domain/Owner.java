package domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class Owner extends Actor{
//Constructores
	public Owner(){
		super();
		academies=new ArrayList<Academy>();
	}

	//Atributos
	private CreditCard creditCard;
	
	@NotNull
	@Valid
	public CreditCard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
//Relaciones
	
	private Collection<Academy> academies;
	
	@Valid
	@NotNull
	@OneToMany(mappedBy = "owner")
	public Collection<Academy> getAcademies() {
		return academies;
	}
	public void setAcademies(Collection<Academy> academies) {
		this.academies = academies;
	}
	
}
