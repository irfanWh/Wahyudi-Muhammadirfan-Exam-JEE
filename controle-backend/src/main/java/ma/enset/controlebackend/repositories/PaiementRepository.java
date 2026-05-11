package ma.enset.controlebackend.repositories;

import ma.enset.controlebackend.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    List<Paiement> findByContratAssuranceId(Long contratId);
}