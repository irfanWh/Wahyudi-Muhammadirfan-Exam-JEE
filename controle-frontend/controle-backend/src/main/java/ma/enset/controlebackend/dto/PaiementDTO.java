package ma.enset.controlebackend.dto;

import lombok.*;
import ma.enset.controlebackend.enums.TypePaiement;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaiementDTO {
    private Long id;
    private LocalDate datePaiement;
    private double montant;
    private TypePaiement typePaiement;
    private Long contratId;
}