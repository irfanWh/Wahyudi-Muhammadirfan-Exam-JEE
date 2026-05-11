package ma.enset.controlebackend.services.impl;

import lombok.AllArgsConstructor;
import ma.enset.controlebackend.dto.*;
import ma.enset.controlebackend.entities.*;
import ma.enset.controlebackend.mappers.ContratMapper;
import ma.enset.controlebackend.repositories.*;
import ma.enset.controlebackend.services.ContratService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ContratServiceImpl implements ContratService {

    private ClientRepository clientRepository;
    private ContratAssuranceRepository contratAssuranceRepository;
    private ContratAutomobileRepository contratAutomobileRepository;
    private ContratHabitationRepository contratHabitationRepository;
    private ContratSanteRepository contratSanteRepository;
    private ContratMapper contratMapper;

    @Override
    public ContratAutomobileDTO saveContratAutomobile(ContratAutomobileDTO dto) {
        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        ContratAutomobile contrat = new ContratAutomobile();
        contrat.setDateSouscription(dto.getDateSouscription());
        contrat.setStatut(dto.getStatut());
        contrat.setDateValidation(dto.getDateValidation());
        contrat.setMontantCotisation(dto.getMontantCotisation());
        contrat.setDureeContrat(dto.getDureeContrat());
        contrat.setTauxCouverture(dto.getTauxCouverture());
        contrat.setClient(client);

        contrat.setNumeroImmatriculation(dto.getNumeroImmatriculation());
        contrat.setMarqueVehicule(dto.getMarqueVehicule());
        contrat.setModeleVehicule(dto.getModeleVehicule());

        ContratAutomobile saved = contratAutomobileRepository.save(contrat);
        return contratMapper.fromContratAutomobile(saved);
    }

    @Override
    public ContratHabitationDTO saveContratHabitation(ContratHabitationDTO dto) {
        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        ContratHabitation contrat = new ContratHabitation();
        contrat.setDateSouscription(dto.getDateSouscription());
        contrat.setStatut(dto.getStatut());
        contrat.setDateValidation(dto.getDateValidation());
        contrat.setMontantCotisation(dto.getMontantCotisation());
        contrat.setDureeContrat(dto.getDureeContrat());
        contrat.setTauxCouverture(dto.getTauxCouverture());
        contrat.setClient(client);

        contrat.setTypeLogement(dto.getTypeLogement());
        contrat.setAdresseLogement(dto.getAdresseLogement());
        contrat.setSuperficie(dto.getSuperficie());

        ContratHabitation saved = contratHabitationRepository.save(contrat);
        return contratMapper.fromContratHabitation(saved);
    }

    @Override
    public ContratSanteDTO saveContratSante(ContratSanteDTO dto) {
        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        ContratSante contrat = new ContratSante();
        contrat.setDateSouscription(dto.getDateSouscription());
        contrat.setStatut(dto.getStatut());
        contrat.setDateValidation(dto.getDateValidation());
        contrat.setMontantCotisation(dto.getMontantCotisation());
        contrat.setDureeContrat(dto.getDureeContrat());
        contrat.setTauxCouverture(dto.getTauxCouverture());
        contrat.setClient(client);

        contrat.setNiveauCouverture(dto.getNiveauCouverture());
        contrat.setNombrePersonnesCouvertes(dto.getNombrePersonnesCouvertes());

        ContratSante saved = contratSanteRepository.save(contrat);
        return contratMapper.fromContratSante(saved);
    }

    @Override
    public List<ContratAutomobileDTO> listContratsAutomobile() {
        return contratAutomobileRepository.findAll()
                .stream()
                .map(contratMapper::fromContratAutomobile)
                .collect(Collectors.toList());
    }

    @Override
    public List<ContratHabitationDTO> listContratsHabitation() {
        return contratHabitationRepository.findAll()
                .stream()
                .map(contratMapper::fromContratHabitation)
                .collect(Collectors.toList());
    }

    @Override
    public List<ContratSanteDTO> listContratsSante() {
        return contratSanteRepository.findAll()
                .stream()
                .map(contratMapper::fromContratSante)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteContrat(Long id) {
        contratAssuranceRepository.deleteById(id);
    }
}