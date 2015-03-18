package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Academy;
import domain.Image;
import domain.Location;
import forms.AcademyForm;
import repositories.AcademyRepository;


@Service
@Transactional
public class AcademyService {

		//Managed Repository
	
		@Autowired
		private AcademyRepository academyRepository;
		
		//Suporting Services
		
		@Autowired OwnerService ownerService;
				
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
			Assert.isTrue(academy.getOwner().getId() == ownerService.findByPrincipal().getId());
			academyRepository.delete(academy);
		}


		//Other business methods
		
		public Academy reconstruct(AcademyForm academyForm, byte[]data) {
			Academy result = create();
			Image image = new Image();
			Location location = new Location();
			
			result.setName(academyForm.getName());
			result.setDescription(academyForm.getDescription());
			
			if(data==null || data.length==0){
				image.setData(null);
				image.setMediaType(null);
			}else{
				String type = academyForm.getMultipartFile().getContentType();
				image.setData(data);
				image.setMediaType(type);
			}
			
			result.setName(academyForm.getName());
			result.setDescription((academyForm.getDescription()));
			result.setCountry((academyForm.getCountry()));
			result.setCity((academyForm.getCity()));
			result.setAddress((academyForm.getAddress()));
			result.setPostcode((academyForm.getPostcode()));
			result.setPhone((academyForm.getPhone()));
			result.setPhone2((academyForm.getPhone2()));
			result.setFax((academyForm.getFax()));
			result.setEmail((academyForm.getEmail()));
			result.setLocation(location);
			result.setIsPremium(false); // TODO ¿Se puede hacer premium al crearla?
			result.setMinPrice((academyForm.getMinPrice()));
			result.setMaxPrice((academyForm.getMaxPrice()));
			result.setTags(getTags(academyForm.getTags()));
			
			
			return result;
		}
		
		private String[] getTags(String tags){
			String[] result;
			String bck = tags;
			
			bck = bck.trim();
			result = bck.split(";");
			
			return result;
		}
		
		public Collection<Academy> search(String s){
			return academyRepository.searchByCityOrTags(s);
		}
		
		public Collection<Academy> findAcademyByOwner(int ownerId){
			return academyRepository.findAcademyByOwner(ownerId);
		}
}
