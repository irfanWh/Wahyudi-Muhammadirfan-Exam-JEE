package ma.enset.controlebackend.services;

import ma.enset.controlebackend.dto.PaiementDTO;

import java.util.List;

public interface PaiementService {
    PaiementDTO savePaiement(PaiementDTO dto);
    List<PaiementDTO> listPaiements();
    List<PaiementDTO> listPaiementsByContrat(Long contratId);
    void deletePaiement(Long id);
}