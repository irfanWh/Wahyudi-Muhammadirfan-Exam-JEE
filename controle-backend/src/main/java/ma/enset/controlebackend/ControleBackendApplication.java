package ma.enset.controlebackend;

import ma.enset.controlebackend.entities.*;
import ma.enset.controlebackend.enums.*;
import ma.enset.controlebackend.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class ControleBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControleBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            ClientRepository clientRepository,
            ContratAutomobileRepository contratAutomobileRepository,
            ContratHabitationRepository contratHabitationRepository,
            ContratSanteRepository contratSanteRepository,
            PaiementRepository paiementRepository,

            AppUserRepository appUserRepository,
            AppRoleRepository appRoleRepository,

            PasswordEncoder passwordEncoder
    ) {
        return args -> {

            Client client1 = Client.builder()
                    .nom("Ahmed Alami")
                    .email("ahmed@gmail.com")
                    .build();

            Client client2 = Client.builder()
                    .nom("Sara Benali")
                    .email("sara@gmail.com")
                    .build();

            clientRepository.save(client1);
            clientRepository.save(client2);

            ContratAutomobile auto = new ContratAutomobile();
            auto.setDateSouscription(LocalDate.now());
            auto.setStatut(StatutContrat.EN_COURS);
            auto.setMontantCotisation(3500);
            auto.setDureeContrat(12);
            auto.setTauxCouverture(80);
            auto.setClient(client1);
            auto.setNumeroImmatriculation("12345-A-6");
            auto.setMarqueVehicule("Toyota");
            auto.setModeleVehicule("Corolla");

            contratAutomobileRepository.save(auto);

            ContratHabitation habitation = new ContratHabitation();
            habitation.setDateSouscription(LocalDate.now());
            habitation.setStatut(StatutContrat.VALIDE);
            habitation.setDateValidation(LocalDate.now());
            habitation.setMontantCotisation(5000);
            habitation.setDureeContrat(24);
            habitation.setTauxCouverture(90);
            habitation.setClient(client1);
            habitation.setTypeLogement(TypeLogement.APPARTEMENT);
            habitation.setAdresseLogement("Casablanca Maarif");
            habitation.setSuperficie(95);

            contratHabitationRepository.save(habitation);

            ContratSante sante = new ContratSante();
            sante.setDateSouscription(LocalDate.now());
            sante.setStatut(StatutContrat.EN_COURS);
            sante.setMontantCotisation(7000);
            sante.setDureeContrat(12);
            sante.setTauxCouverture(75);
            sante.setClient(client2);
            sante.setNiveauCouverture(NiveauCouverture.PREMIUM);
            sante.setNombrePersonnesCouvertes(4);

            contratSanteRepository.save(sante);

            Paiement paiement1 = Paiement.builder()
                    .datePaiement(LocalDate.now())
                    .montant(500)
                    .typePaiement(TypePaiement.MENSUALITE)
                    .contratAssurance(auto)
                    .build();

            Paiement paiement2 = Paiement.builder()
                    .datePaiement(LocalDate.now())
                    .montant(5000)
                    .typePaiement(TypePaiement.PAIEMENT_ANNUEL)
                    .contratAssurance(habitation)
                    .build();

            paiementRepository.save(paiement1);
            paiementRepository.save(paiement2);

            System.out.println("Clients:");
            clientRepository.findAll().forEach(c -> {
                System.out.println(c.getId() + " - " + c.getNom() + " - " + c.getEmail());
            });

            System.out.println("Contrats:");
            contratAutomobileRepository.findAll().forEach(c -> {
                System.out.println(c.getId() + " - " + c.getMarqueVehicule() + " - " + c.getModeleVehicule());
            });

            System.out.println("Paiements:");
            paiementRepository.findAll().forEach(p -> {
                System.out.println(p.getId() + " - " + p.getMontant() + " - " + p.getTypePaiement());
            });
            AppRole adminRole = AppRole.builder()
                    .roleName("ROLE_ADMIN")
                    .build();

            AppRole employeRole = AppRole.builder()
                    .roleName("ROLE_EMPLOYE")
                    .build();

            AppRole clientRole = AppRole.builder()
                    .roleName("ROLE_CLIENT")
                    .build();

            appRoleRepository.save(adminRole);
            appRoleRepository.save(employeRole);
            appRoleRepository.save(clientRole);

            AppUser admin = AppUser.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("1234"))
                    .roles(List.of(adminRole))
                    .build();

            AppUser employe = AppUser.builder()
                    .username("employe")
                    .password(passwordEncoder.encode("1234"))
                    .roles(List.of(employeRole))
                    .build();

            AppUser client = AppUser.builder()
                    .username("client")
                    .password(passwordEncoder.encode("1234"))
                    .roles(List.of(clientRole))
                    .build();

            appUserRepository.save(admin);
            appUserRepository.save(employe);
            appUserRepository.save(client);
        };
    }
}