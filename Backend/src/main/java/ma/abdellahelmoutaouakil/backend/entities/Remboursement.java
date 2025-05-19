package ma.abdellahelmoutaouakil.backend.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
public class Remboursement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private double montant;
    @Enumerated(jakarta.persistence.EnumType.STRING)
    private ma.abdellahelmoutaouakil.backend.enums.TypeRemboursement type;

    @ManyToOne
    private Credit credit;
} 