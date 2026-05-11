package ma.enset.controlebackend.dto;

import lombok.*;
import ma.enset.controlebackend.enums.StatutContrat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContratAutomobileDTO {
    private Long id;
    private LocalDate dateSouscription;
    private StatutContrat statut;
    private LocalDate dateValidation;
    private double montantCotisation;
    private int dureeContrat;
    private double tauxCouverture;
    private Long clientId;

    private String numeroImmatriculation;
    private String marqueVehicule;
    private String modeleVehicule;
}