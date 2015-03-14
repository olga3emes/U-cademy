package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Inscription;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {

}
