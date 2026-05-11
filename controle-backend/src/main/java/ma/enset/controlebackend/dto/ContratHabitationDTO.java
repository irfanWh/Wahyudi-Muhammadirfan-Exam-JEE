package ma.enset.controlebackend.dto;

import lombok.*;
import ma.enset.controlebackend.enums.StatutContrat;
import ma.enset.controlebackend.enums.TypeLogement;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContratHabitationDTO {
    private Long id;
    private LocalDate dateSouscription;
    private StatutContrat statut;
    private LocalDate dateValidation;
    private double montantCotisation;
    private int dureeContrat;
    private double tauxCouverture;
    private Long clientId;

    private TypeLogement typeLogement;
    private String adresseLogement;
    private double superficie;
}