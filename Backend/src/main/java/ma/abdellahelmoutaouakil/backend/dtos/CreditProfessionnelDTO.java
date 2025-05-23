package ma.abdellahelmoutaouakil.backend.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreditProfessionnelDTO extends CreditDTO {
    private String motif;
    private String raisonSociale;
} 