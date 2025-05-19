package ma.abdellahelmoutaouakil.backend.services;

import lombok.RequiredArgsConstructor;
import ma.abdellahelmoutaouakil.backend.dtos.ClientDTO;
import ma.abdellahelmoutaouakil.backend.entities.Client;
import ma.abdellahelmoutaouakil.backend.mappers.BankMapperImpl;
import ma.abdellahelmoutaouakil.backend.repositories.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final BankMapperImpl mapper;

    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client client = mapper.fromClientDTO(clientDTO);
        return mapper.fromClient(clientRepository.save(client));
    }

    @Override
    public ClientDTO getClient(Long id) {
        return clientRepository.findById(id)
                .map(mapper::fromClient)
                .orElse(null);
    }

    @Override
    public List<ClientDTO> listClients() {
        return clientRepository.findAll().stream()
                .map(mapper::fromClient)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
} 