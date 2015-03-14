package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}
