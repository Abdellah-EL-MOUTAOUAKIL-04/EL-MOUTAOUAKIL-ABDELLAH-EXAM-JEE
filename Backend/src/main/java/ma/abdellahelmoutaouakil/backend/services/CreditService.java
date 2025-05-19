package ma.abdellahelmoutaouakil.backend.services;

import ma.abdellahelmoutaouakil.backend.dtos.*;
import java.util.List;

public interface CreditService {
    CreditDTO saveCredit(CreditDTO creditDTO);
    CreditDTO getCredit(Long id);
    List<CreditDTO> listCredits();
    void deleteCredit(Long id);
    List<CreditDTO> findCreditsByClient(Long clientId);

    CreditPersonnelDTO saveCreditPersonnel(CreditPersonnelDTO dto);
    CreditImmobilierDTO saveCreditImmobilier(CreditImmobilierDTO dto);
    CreditProfessionnelDTO saveCreditProfessionnel(CreditProfessionnelDTO dto);
} 