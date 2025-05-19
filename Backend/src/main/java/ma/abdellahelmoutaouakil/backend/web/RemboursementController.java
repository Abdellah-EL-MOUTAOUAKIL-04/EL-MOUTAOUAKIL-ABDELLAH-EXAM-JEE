package ma.abdellahelmoutaouakil.backend.web;

import lombok.RequiredArgsConstructor;
import ma.abdellahelmoutaouakil.backend.dtos.RemboursementDTO;
import ma.abdellahelmoutaouakil.backend.services.RemboursementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remboursements")
@RequiredArgsConstructor
public class RemboursementController {
    private final RemboursementService remboursementService;

    @GetMapping
    public List<RemboursementDTO> allRemboursements() {
        return remboursementService.listRemboursements();
    }

    @GetMapping("/{id}")
    public RemboursementDTO getRemboursement(@PathVariable Long id) {
        return remboursementService.getRemboursement(id);
    }

    @GetMapping("/by-credit/{creditId}")
    public List<RemboursementDTO> remboursementsByCredit(@PathVariable Long creditId) {
        return remboursementService.findRemboursementsByCredit(creditId);
    }

    @PostMapping
    public RemboursementDTO createRemboursement(@RequestBody RemboursementDTO dto) {
        return remboursementService.saveRemboursement(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteRemboursement(@PathVariable Long id) {
        remboursementService.deleteRemboursement(id);
    }
} 