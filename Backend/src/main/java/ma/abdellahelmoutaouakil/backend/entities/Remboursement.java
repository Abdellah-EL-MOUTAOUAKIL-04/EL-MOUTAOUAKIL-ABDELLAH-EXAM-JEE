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
    private String type;

    @ManyToOne
    private Credit credit;
} 