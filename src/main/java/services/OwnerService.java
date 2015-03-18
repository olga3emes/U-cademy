package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Owner;
import repositories.OwnerRepository;
import security.LoginService;
import security.UserAccount;


@Service
@Transactional
public class OwnerService {

		//Managed Repository
	
		@Autowired
		private OwnerRepository ownerRepository;
		
		//Suporting Services
		
				
		//Constructor
		public OwnerService(){
			super();
		}
		
		//Simple CRUD methods
		
		public Owner create(){
			Owner owner = new Owner();
			
			return owner;
		}	
		public Collection<Owner> findAll(){
			return ownerRepository.findAll();
		}
		public Owner findOne(int ownerId){
			Assert.isTrue(ownerId > 0);
			return ownerRepository.findOne(ownerId);
		}
		public Owner save(Owner owner){
			Assert.notNull(owner);
			
			Owner t = ownerRepository.save(owner);
			return t;
			
		}
		public void delete(Owner owner){
			Assert.notNull(owner);
			//Assert.isTrue(owner.getOwner().getId() == ownerService.findByPrincipal().getId());
			ownerRepository.delete(owner);
		}


		//Other business methods

		public Owner findByPrincipal() {
			Owner result;
			UserAccount userAccount;
		
			userAccount = LoginService.getPrincipal();
			Assert.notNull(userAccount);
			result = findByUserAccount(userAccount);
			

			return result;
		}
		
		public Owner findByUserAccount(UserAccount userAccount) {
			Assert.notNull(userAccount);

			Owner result;

			result = ownerRepository.findByOwnerAccountId(userAccount.getId());		

			return result;
		}

}
