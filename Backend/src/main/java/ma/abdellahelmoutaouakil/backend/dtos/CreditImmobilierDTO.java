package ma.abdellahelmoutaouakil.backend.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ma.abdellahelmoutaouakil.backend.enums.TypeBien;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreditImmobilierDTO extends CreditDTO {
    private TypeBien typeBien;
} 