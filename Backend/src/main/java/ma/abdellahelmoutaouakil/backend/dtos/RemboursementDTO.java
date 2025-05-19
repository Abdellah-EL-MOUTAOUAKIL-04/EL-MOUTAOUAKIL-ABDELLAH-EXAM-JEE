package ma.abdellahelmoutaouakil.backend.dtos;

import lombok.Data;
import java.util.Date;
import ma.abdellahelmoutaouakil.backend.enums.TypeRemboursement;

@Data
public class RemboursementDTO {
    private Long id;
    private Date date;
    private double montant;
    private TypeRemboursement type;
    private Long creditId;
} 