package ma.abdellahelmoutaouakil.backend.services;

import lombok.RequiredArgsConstructor;
import ma.abdellahelmoutaouakil.backend.dtos.*;
import ma.abdellahelmoutaouakil.backend.entities.*;
import ma.abdellahelmoutaouakil.backend.mappers.BankMapperImpl;
import ma.abdellahelmoutaouakil.backend.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CreditServiceImpl implements CreditService {
    private final CreditRepository creditRepository;
    private final CreditPersonnelRepository creditPersonnelRepository;
    private final CreditImmobilierRepository creditImmobilierRepository;
    private final CreditProfessionnelRepository creditProfessionnelRepository;
    private final ClientRepository clientRepository;
    private final BankMapperImpl mapper;

    @Override
    public CreditDTO saveCredit(CreditDTO creditDTO) {
        Credit credit = mapper.fromCreditDTO(creditDTO);
        if (creditDTO.getClientId() != null) {
            clientRepository.findById(creditDTO.getClientId()).ifPresent(credit::setClient);
        }
        return mapper.fromCredit(creditRepository.save(credit));
    }

    @Override
    public CreditDTO getCredit(Long id) {
        return creditRepository.findById(id)
                .map(mapper::fromCredit)
                .orElse(null);
    }

    @Override
    public List<CreditDTO> listCredits() {
        return creditRepository.findAll().stream()
                .map(mapper::fromCredit)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCredit(Long id) {
        creditRepository.deleteById(id);
    }

    @Override
    public List<CreditDTO> findCreditsByClient(Long clientId) {
        return creditRepository.findAll().stream()
                .filter(c -> c.getClient() != null && c.getClient().getId().equals(clientId))
                .map(mapper::fromCredit)
                .collect(Collectors.toList());
    }

    @Override
    public CreditPersonnelDTO saveCreditPersonnel(CreditPersonnelDTO dto) {
        CreditPersonnel credit = mapper.fromCreditPersonnelDTO(dto);
        if (dto.getClientId() != null) {
            clientRepository.findById(dto.getClientId()).ifPresent(credit::setClient);
        }
        return mapper.fromCreditPersonnel(creditPersonnelRepository.save(credit));
    }

    @Override
    public CreditImmobilierDTO saveCreditImmobilier(CreditImmobilierDTO dto) {
        CreditImmobilier credit = mapper.fromCreditImmobilierDTO(dto);
        if (dto.getClientId() != null) {
            clientRepository.findById(dto.getClientId()).ifPresent(credit::setClient);
        }
        return mapper.fromCreditImmobilier(creditImmobilierRepository.save(credit));
    }

    @Override
    public CreditProfessionnelDTO saveCreditProfessionnel(CreditProfessionnelDTO dto) {
        CreditProfessionnel credit = mapper.fromCreditProfessionnelDTO(dto);
        if (dto.getClientId() != null) {
            clientRepository.findById(dto.getClientId()).ifPresent(credit::setClient);
        }
        return mapper.fromCreditProfessionnel(creditProfessionnelRepository.save(credit));
    }
} 