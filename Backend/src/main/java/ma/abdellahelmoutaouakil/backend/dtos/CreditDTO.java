package ma.abdellahelmoutaouakil.backend.dtos;

import lombok.Data;
import java.util.Date;
import ma.abdellahelmoutaouakil.backend.enums.StatutCredit;

@Data
public class CreditDTO {
    private Long id;
    private Date dateDemande;
    private StatutCredit statut;
    private Date dateAcceptation;
    private double montant;
    private int dureeRemboursement;
    private double tauxInteret;
    private Long clientId;
} 