package ma.enset.controlebackend.repositories;

import ma.enset.controlebackend.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}