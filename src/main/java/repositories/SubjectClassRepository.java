package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.SubjectClass;

@Repository
public interface SubjectClassRepository extends JpaRepository<SubjectClass, Integer> {

}
