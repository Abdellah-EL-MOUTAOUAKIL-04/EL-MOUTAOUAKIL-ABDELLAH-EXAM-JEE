package ma.abdellahelmoutaouakil.backend.mappers;

import ma.abdellahelmoutaouakil.backend.dtos.*;
import ma.abdellahelmoutaouakil.backend.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class BankMapperImpl {
    // Client
    public ClientDTO fromClient(Client client) {
        ClientDTO dto = new ClientDTO();
        BeanUtils.copyProperties(client, dto);
        return dto;
    }
    public Client fromClientDTO(ClientDTO dto) {
        Client client = new Client();
        BeanUtils.copyProperties(dto, client);
        return client;
    }

    // Credit (abstrait)
    public CreditDTO fromCredit(Credit credit) {
        CreditDTO dto = new CreditDTO();
        BeanUtils.copyProperties(credit, dto);
        if (credit.getClient() != null) dto.setClientId(credit.getClient().getId());
        return dto;
    }
    public Credit fromCreditDTO(CreditDTO dto) {
        Credit credit = new CreditPersonnel(); // Par défaut, à spécialiser selon le type réel
        BeanUtils.copyProperties(dto, credit);
        return credit;
    }

    // CreditPersonnel
    public CreditPersonnelDTO fromCreditPersonnel(CreditPersonnel credit) {
        CreditPersonnelDTO dto = new CreditPersonnelDTO();
        BeanUtils.copyProperties(credit, dto);
        if (credit.getClient() != null) dto.setClientId(credit.getClient().getId());
        return dto;
    }
    public CreditPersonnel fromCreditPersonnelDTO(CreditPersonnelDTO dto) {
        CreditPersonnel credit = new CreditPersonnel();
        BeanUtils.copyProperties(dto, credit);
        return credit;
    }

    // CreditImmobilier
    public CreditImmobilierDTO fromCreditImmobilier(CreditImmobilier credit) {
        CreditImmobilierDTO dto = new CreditImmobilierDTO();
        BeanUtils.copyProperties(credit, dto);
        if (credit.getClient() != null) dto.setClientId(credit.getClient().getId());
        return dto;
    }
    public CreditImmobilier fromCreditImmobilierDTO(CreditImmobilierDTO dto) {
        CreditImmobilier credit = new CreditImmobilier();
        BeanUtils.copyProperties(dto, credit);
        return credit;
    }

    // CreditProfessionnel
    public CreditProfessionnelDTO fromCreditProfessionnel(CreditProfessionnel credit) {
        CreditProfessionnelDTO dto = new CreditProfessionnelDTO();
        BeanUtils.copyProperties(credit, dto);
        if (credit.getClient() != null) dto.setClientId(credit.getClient().getId());
        return dto;
    }
    public CreditProfessionnel fromCreditProfessionnelDTO(CreditProfessionnelDTO dto) {
        CreditProfessionnel credit = new CreditProfessionnel();
        BeanUtils.copyProperties(dto, credit);
        return credit;
    }

    // Remboursement
    public RemboursementDTO fromRemboursement(Remboursement remboursement) {
        RemboursementDTO dto = new RemboursementDTO();
        BeanUtils.copyProperties(remboursement, dto);
        if (remboursement.getCredit() != null) dto.setCreditId(remboursement.getCredit().getId());
        return dto;
    }
    public Remboursement fromRemboursementDTO(RemboursementDTO dto) {
        Remboursement remboursement = new Remboursement();
        BeanUtils.copyProperties(dto, remboursement);
        return remboursement;
    }
} 