package ma.enset.controlebackend.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.controlebackend.enums.TypeLogement;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("HABITATION")
public class ContratHabitation extends ContratAssurance {

    @Enumerated(EnumType.STRING)
    private TypeLogement typeLogement;

    private String adresseLogement;

    private double superficie;
}