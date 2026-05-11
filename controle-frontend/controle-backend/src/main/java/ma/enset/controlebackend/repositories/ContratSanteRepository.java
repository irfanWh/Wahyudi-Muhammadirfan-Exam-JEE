package ma.enset.controlebackend.repositories;

import ma.enset.controlebackend.entities.ContratSante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratSanteRepository extends JpaRepository<ContratSante, Long> {
}