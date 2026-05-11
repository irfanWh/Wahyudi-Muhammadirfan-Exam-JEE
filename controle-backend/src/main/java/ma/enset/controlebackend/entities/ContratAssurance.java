package ma.enset.controlebackend.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.controlebackend.enums.StatutContrat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_contrat")
public abstract class ContratAssurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateSouscription;

    @Enumerated(EnumType.STRING)
    private StatutContrat statut;

    private LocalDate dateValidation;

    private double montantCotisation;

    private int dureeContrat;

    private double tauxCouverture;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "contratAssurance", cascade = CascadeType.ALL)
    private List<Paiement> paiements = new ArrayList<>();
}