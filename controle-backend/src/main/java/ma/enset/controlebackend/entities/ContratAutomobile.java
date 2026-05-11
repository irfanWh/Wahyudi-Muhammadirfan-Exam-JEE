package ma.enset.controlebackend.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("AUTOMOBILE")
public class ContratAutomobile extends ContratAssurance {

    private String numeroImmatriculation;

    private String marqueVehicule;

    private String modeleVehicule;
}