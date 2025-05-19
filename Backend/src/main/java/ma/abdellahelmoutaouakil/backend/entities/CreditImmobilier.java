package ma.abdellahelmoutaouakil.backend.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@DiscriminatorValue("IMMOBILIER")
public class CreditImmobilier extends Credit {
    private String typeBien;
} 