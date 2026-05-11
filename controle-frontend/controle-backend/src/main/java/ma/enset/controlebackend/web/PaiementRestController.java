package ma.enset.controlebackend.web;

import lombok.AllArgsConstructor;
import ma.enset.controlebackend.dto.PaiementDTO;
import ma.enset.controlebackend.services.PaiementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
@AllArgsConstructor
@CrossOrigin("*")
public class PaiementRestController {

    private PaiementService paiementService;

    @GetMapping
    public List<PaiementDTO> listPaiements() {
        return paiementService.listPaiements();
    }

    @GetMapping("/contrat/{contratId}")
    public List<PaiementDTO> listPaiementsByContrat(
            @PathVariable Long contratId) {
        return paiementService.listPaiementsByContrat(contratId);
    }

    @PostMapping
    public PaiementDTO savePaiement(@RequestBody PaiementDTO dto) {
        return paiementService.savePaiement(dto);
    }

    @DeleteMapping("/{id}")
    public void deletePaiement(@PathVariable Long id) {
        paiementService.deletePaiement(id);
    }
}