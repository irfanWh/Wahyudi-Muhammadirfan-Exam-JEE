package ma.enset.controlebackend.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.controlebackend.enums.TypePaiement;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate datePaiement;

    private double montant;

    @Enumerated(EnumType.STRING)
    private TypePaiement typePaiement;

    @ManyToOne
    private ContratAssurance contratAssurance;
}