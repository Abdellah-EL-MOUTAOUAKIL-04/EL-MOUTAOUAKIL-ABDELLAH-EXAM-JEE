package ma.abdellahelmoutaouakil.backend.services;

import lombok.RequiredArgsConstructor;
import ma.abdellahelmoutaouakil.backend.dtos.RemboursementDTO;
import ma.abdellahelmoutaouakil.backend.entities.Credit;
import ma.abdellahelmoutaouakil.backend.entities.Remboursement;
import ma.abdellahelmoutaouakil.backend.mappers.BankMapperImpl;
import ma.abdellahelmoutaouakil.backend.repositories.CreditRepository;
import ma.abdellahelmoutaouakil.backend.repositories.RemboursementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class RemboursementServiceImpl implements RemboursementService {
    private final RemboursementRepository remboursementRepository;
    private final CreditRepository creditRepository;
    private final BankMapperImpl mapper;

    @Override
    public RemboursementDTO saveRemboursement(RemboursementDTO dto) {
        Remboursement remboursement = mapper.fromRemboursementDTO(dto);
        if (dto.getCreditId() != null) {
            creditRepository.findById(dto.getCreditId()).ifPresent(remboursement::setCredit);
        }
        return mapper.fromRemboursement(remboursementRepository.save(remboursement));
    }

    @Override
    public RemboursementDTO getRemboursement(Long id) {
        return remboursementRepository.findById(id)
                .map(mapper::fromRemboursement)
                .orElse(null);
    }

    @Override
    public List<RemboursementDTO> listRemboursements() {
        return remboursementRepository.findAll().stream()
                .map(mapper::fromRemboursement)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRemboursement(Long id) {
        remboursementRepository.deleteById(id);
    }

    @Override
    public List<RemboursementDTO> findRemboursementsByCredit(Long creditId) {
        return remboursementRepository.findAll().stream()
                .filter(r -> r.getCredit() != null && r.getCredit().getId().equals(creditId))
                .map(mapper::fromRemboursement)
                .collect(Collectors.toList());
    }
} 