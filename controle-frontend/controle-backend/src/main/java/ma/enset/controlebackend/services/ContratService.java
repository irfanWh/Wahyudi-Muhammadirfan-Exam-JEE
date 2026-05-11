package ma.enset.controlebackend.services;

import ma.enset.controlebackend.dto.*;

import java.util.List;

public interface ContratService {
    ContratAutomobileDTO saveContratAutomobile(ContratAutomobileDTO dto);
    ContratHabitationDTO saveContratHabitation(ContratHabitationDTO dto);
    ContratSanteDTO saveContratSante(ContratSanteDTO dto);

    List<ContratAutomobileDTO> listContratsAutomobile();
    List<ContratHabitationDTO> listContratsHabitation();
    List<ContratSanteDTO> listContratsSante();

    void deleteContrat(Long id);
}