package ma.abdellahelmoutaouakil.backend.repositories;

import ma.abdellahelmoutaouakil.backend.entities.CreditImmobilier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditImmobilierRepository extends JpaRepository<CreditImmobilier, Long> {
} 