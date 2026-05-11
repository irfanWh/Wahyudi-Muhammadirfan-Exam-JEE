package ma.enset.controlebackend.repositories;

import ma.enset.controlebackend.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}