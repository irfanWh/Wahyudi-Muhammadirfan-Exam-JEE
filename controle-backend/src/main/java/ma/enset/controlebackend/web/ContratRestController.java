package ma.enset.controlebackend.web;

import lombok.AllArgsConstructor;
import ma.enset.controlebackend.dto.ContratAutomobileDTO;
import ma.enset.controlebackend.dto.ContratHabitationDTO;
import ma.enset.controlebackend.dto.ContratSanteDTO;
import ma.enset.controlebackend.services.ContratService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contrats")
@AllArgsConstructor
@CrossOrigin("*")
public class ContratRestController {

    private ContratService contratService;

    @PostMapping("/automobile")
    public ContratAutomobileDTO saveContratAutomobile(
            @RequestBody ContratAutomobileDTO dto) {
        return contratService.saveContratAutomobile(dto);
    }

    @GetMapping("/automobile")
    public List<ContratAutomobileDTO> listContratsAutomobile() {
        return contratService.listContratsAutomobile();
    }

    @PostMapping("/habitation")
    public ContratHabitationDTO saveContratHabitation(
            @RequestBody ContratHabitationDTO dto) {
        return contratService.saveContratHabitation(dto);
    }

    @GetMapping("/habitation")
    public List<ContratHabitationDTO> listContratsHabitation() {
        return contratService.listContratsHabitation();
    }

    @PostMapping("/sante")
    public ContratSanteDTO saveContratSante(
            @RequestBody ContratSanteDTO dto) {
        return contratService.saveContratSante(dto);
    }

    @GetMapping("/sante")
    public List<ContratSanteDTO> listContratsSante() {
        return contratService.listContratsSante();
    }

    @DeleteMapping("/{id}")
    public void deleteContrat(@PathVariable Long id) {
        contratService.deleteContrat(id);
    }
}