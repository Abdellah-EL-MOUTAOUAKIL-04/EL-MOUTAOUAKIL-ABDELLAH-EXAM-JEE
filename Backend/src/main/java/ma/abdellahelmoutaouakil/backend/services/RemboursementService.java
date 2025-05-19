package ma.abdellahelmoutaouakil.backend.services;

import ma.abdellahelmoutaouakil.backend.dtos.RemboursementDTO;
import java.util.List;

public interface RemboursementService {
    RemboursementDTO saveRemboursement(RemboursementDTO dto);
    RemboursementDTO getRemboursement(Long id);
    List<RemboursementDTO> listRemboursements();
    void deleteRemboursement(Long id);
    List<RemboursementDTO> findRemboursementsByCredit(Long creditId);
} 