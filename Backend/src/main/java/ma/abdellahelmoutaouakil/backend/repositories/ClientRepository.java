package ma.abdellahelmoutaouakil.backend.repositories;

import ma.abdellahelmoutaouakil.backend.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
} 