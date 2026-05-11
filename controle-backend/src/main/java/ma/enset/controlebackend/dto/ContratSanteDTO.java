package ma.enset.controlebackend.dto;

import lombok.*;
import ma.enset.controlebackend.enums.NiveauCouverture;
import ma.enset.controlebackend.enums.StatutContrat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContratSanteDTO {
    private Long id;
    private LocalDate dateSouscription;
    private StatutContrat statut;
    private LocalDate dateValidation;
    private double montantCotisation;
    private int dureeContrat;
    private double tauxCouverture;
    private Long clientId;

    private NiveauCouverture niveauCouverture;
    private int nombrePersonnesCouvertes;
}