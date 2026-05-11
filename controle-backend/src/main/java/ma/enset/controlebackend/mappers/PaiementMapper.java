package ma.enset.controlebackend.mappers;

import ma.enset.controlebackend.dto.PaiementDTO;
import ma.enset.controlebackend.entities.Paiement;
import org.springframework.stereotype.Component;

@Component
public class PaiementMapper {

    public PaiementDTO fromPaiement(Paiement paiement) {
        return PaiementDTO.builder()
                .id(paiement.getId())
                .datePaiement(paiement.getDatePaiement())
                .montant(paiement.getMontant())
                .typePaiement(paiement.getTypePaiement())
                .contratId(paiement.getContratAssurance() != null ? paiement.getContratAssurance().getId() : null)
                .build();
    }
}