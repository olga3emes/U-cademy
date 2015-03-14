package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
}
