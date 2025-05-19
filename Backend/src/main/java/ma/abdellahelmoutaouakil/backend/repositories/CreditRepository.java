package ma.abdellahelmoutaouakil.backend.repositories;

import ma.abdellahelmoutaouakil.backend.entities.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<Credit, Long> {
} 