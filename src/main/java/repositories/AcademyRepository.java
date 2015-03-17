package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Academy;



@Repository
public interface AcademyRepository extends JpaRepository<Academy, Integer> {
	
	@Query("select a from Academy a where a.city like %?1% or %?1% in a.tags")
	Collection<Academy> searchByCityOrTags(String s);

}
