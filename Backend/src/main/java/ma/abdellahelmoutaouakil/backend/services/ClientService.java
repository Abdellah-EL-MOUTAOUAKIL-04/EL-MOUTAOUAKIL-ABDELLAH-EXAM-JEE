package ma.abdellahelmoutaouakil.backend.services;

import ma.abdellahelmoutaouakil.backend.dtos.ClientDTO;
import java.util.List;

public interface ClientService {
    ClientDTO saveClient(ClientDTO clientDTO);
    ClientDTO getClient(Long id);
    List<ClientDTO> listClients();
    void deleteClient(Long id);
} 