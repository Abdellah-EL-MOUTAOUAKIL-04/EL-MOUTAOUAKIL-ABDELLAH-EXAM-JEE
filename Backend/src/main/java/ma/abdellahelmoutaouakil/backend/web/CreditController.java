package ma.abdellahelmoutaouakil.backend.web;

import lombok.RequiredArgsConstructor;
import ma.abdellahelmoutaouakil.backend.dtos.*;
import ma.abdellahelmoutaouakil.backend.services.CreditService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credits")
@RequiredArgsConstructor
public class CreditController {
    private final CreditService creditService;

    @GetMapping
    public List<CreditDTO> allCredits() {
        return creditService.listCredits();
    }

    @GetMapping("/{id}")
    public CreditDTO getCredit(@PathVariable Long id) {
        return creditService.getCredit(id);
    }

    @GetMapping("/by-client/{clientId}")
    public List<CreditDTO> creditsByClient(@PathVariable Long clientId) {
        return creditService.findCreditsByClient(clientId);
    }

    @PostMapping
    public CreditDTO createCredit(@RequestBody CreditDTO dto) {
        return creditService.saveCredit(dto);
    }

    @PostMapping("/personnel")
    public CreditPersonnelDTO createCreditPersonnel(@RequestBody CreditPersonnelDTO dto) {
        return creditService.saveCreditPersonnel(dto);
    }

    @PostMapping("/immobilier")
    public CreditImmobilierDTO createCreditImmobilier(@RequestBody CreditImmobilierDTO dto) {
        return creditService.saveCreditImmobilier(dto);
    }

    @PostMapping("/professionnel")
    public CreditProfessionnelDTO createCreditProfessionnel(@RequestBody CreditProfessionnelDTO dto) {
        return creditService.saveCreditProfessionnel(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteCredit(@PathVariable Long id) {
        creditService.deleteCredit(id);
    }
} 