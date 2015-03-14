package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
