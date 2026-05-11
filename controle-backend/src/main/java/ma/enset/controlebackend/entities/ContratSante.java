package ma.enset.controlebackend.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.controlebackend.enums.NiveauCouverture;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("SANTE")
public class ContratSante extends ContratAssurance {

    @Enumerated(EnumType.STRING)
    private NiveauCouverture niveauCouverture;

    private int nombrePersonnesCouvertes;
}