package services;


import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Academy;
import forms.AcademyForm;
import repositories.AcademyRepository;


@Service
@Transactional
public class AcademyService {

		//Managed Repository
	
		@Autowired
		private AcademyRepository academyRepository;
		
		//Suporting Services
		
		//@Autowired OwnerService ownerService;
				
		//Constructor
		public AcademyService(){
			super();
		}
		
		//Simple CRUD methods
		
		public Academy create(){
			Academy academy = new Academy();
			
			return academy;
		}	
		public Collection<Academy> findAll(){
			return academyRepository.findAll();
		}
		public Academy findOne(int academyId){
			Assert.isTrue(academyId > 0);
			return academyRepository.findOne(academyId);
		}
		public Academy save(Academy academy){
			Assert.notNull(academy);
			
			Academy t = academyRepository.save(academy);
			return t;
			
		}
		public void delete(Academy academy){
			Assert.notNull(academy);
			//Assert.isTrue(academy.getOwner().getId() == ownerService.findByPrincipal().getId());
			academyRepository.delete(academy);
		}


		//Other business methods
		
		public Academy reconstruct(AcademyForm academyForm) {
			Academy result = create();
			
			result.setName(academyForm.getName());
			result.setDescription(academyForm.getDescription());
			// TODO
			
			return result;
		}

		public AcademyForm contruct(int academyId) {
			AcademyForm result = new AcademyForm();
			
			Academy academy = findOne(academyId);
			Assert.notNull(academy);
			//Assert.isTrue(academy.getOwner().getId() == ownerService.findByPrincipal().getId());
			
			result.setName(academy.getName());
			result.setDescription(academy.getDescription());
			//TODO
			
			return result;
		}
		
		public Collection<Academy> search(String s){
			return academyRepository.searchByCityOrTags(s);
		}

}
