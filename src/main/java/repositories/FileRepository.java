package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.File;

@Repository
public interface FileRepository extends JpaRepository<File, Integer> {

}
