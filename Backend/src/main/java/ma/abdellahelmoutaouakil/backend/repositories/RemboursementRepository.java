package ma.abdellahelmoutaouakil.backend.repositories;

import ma.abdellahelmoutaouakil.backend.entities.Remboursement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemboursementRepository extends JpaRepository<Remboursement, Long> {
} 