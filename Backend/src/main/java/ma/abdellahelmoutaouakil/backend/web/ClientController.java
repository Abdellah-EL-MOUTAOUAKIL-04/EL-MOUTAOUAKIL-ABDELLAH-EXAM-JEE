package ma.abdellahelmoutaouakil.backend.web;

import lombok.RequiredArgsConstructor;
import ma.abdellahelmoutaouakil.backend.dtos.ClientDTO;
import ma.abdellahelmoutaouakil.backend.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public List<ClientDTO> allClients() {
        return clientService.listClients();
    }

    @GetMapping("/{id}")
    public ClientDTO getClient(@PathVariable Long id) {
        return clientService.getClient(id);
    }

    @PostMapping
    public ClientDTO createClient(@RequestBody ClientDTO dto) {
        return clientService.saveClient(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
} 