package ma.enset.controlebackend.mappers;

import ma.enset.controlebackend.dto.*;
import ma.enset.controlebackend.entities.*;
import org.springframework.stereotype.Component;

@Component
public class ContratMapper {

    public ContratAutomobileDTO fromContratAutomobile(ContratAutomobile contrat) {
        return ContratAutomobileDTO.builder()
                .id(contrat.getId())
                .dateSouscription(contrat.getDateSouscription())
                .statut(contrat.getStatut())
                .dateValidation(contrat.getDateValidation())
                .montantCotisation(contrat.getMontantCotisation())
                .dureeContrat(contrat.getDureeContrat())
                .tauxCouverture(contrat.getTauxCouverture())
                .clientId(contrat.getClient() != null ? contrat.getClient().getId() : null)
                .numeroImmatriculation(contrat.getNumeroImmatriculation())
                .marqueVehicule(contrat.getMarqueVehicule())
                .modeleVehicule(contrat.getModeleVehicule())
                .build();
    }

    public ContratHabitationDTO fromContratHabitation(ContratHabitation contrat) {
        return ContratHabitationDTO.builder()
                .id(contrat.getId())
                .dateSouscription(contrat.getDateSouscription())
                .statut(contrat.getStatut())
                .dateValidation(contrat.getDateValidation())
                .montantCotisation(contrat.getMontantCotisation())
                .dureeContrat(contrat.getDureeContrat())
                .tauxCouverture(contrat.getTauxCouverture())
                .clientId(contrat.getClient() != null ? contrat.getClient().getId() : null)
                .typeLogement(contrat.getTypeLogement())
                .adresseLogement(contrat.getAdresseLogement())
                .superficie(contrat.getSuperficie())
                .build();
    }

    public ContratSanteDTO fromContratSante(ContratSante contrat) {
        return ContratSanteDTO.builder()
                .id(contrat.getId())
                .dateSouscription(contrat.getDateSouscription())
                .statut(contrat.getStatut())
                .dateValidation(contrat.getDateValidation())
                .montantCotisation(contrat.getMontantCotisation())
                .dureeContrat(contrat.getDureeContrat())
                .tauxCouverture(contrat.getTauxCouverture())
                .clientId(contrat.getClient() != null ? contrat.getClient().getId() : null)
                .niveauCouverture(contrat.getNiveauCouverture())
                .nombrePersonnesCouvertes(contrat.getNombrePersonnesCouvertes())
                .build();
    }
}