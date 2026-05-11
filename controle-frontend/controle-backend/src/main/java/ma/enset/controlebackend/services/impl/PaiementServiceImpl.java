package ma.enset.controlebackend.services.impl;

import lombok.AllArgsConstructor;
import ma.enset.controlebackend.dto.PaiementDTO;
import ma.enset.controlebackend.entities.ContratAssurance;
import ma.enset.controlebackend.entities.Paiement;
import ma.enset.controlebackend.mappers.PaiementMapper;
import ma.enset.controlebackend.repositories.ContratAssuranceRepository;
import ma.enset.controlebackend.repositories.PaiementRepository;
import ma.enset.controlebackend.services.PaiementService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PaiementServiceImpl implements PaiementService {

    private PaiementRepository paiementRepository;
    private ContratAssuranceRepository contratAssuranceRepository;
    private PaiementMapper paiementMapper;

    @Override
    public PaiementDTO savePaiement(PaiementDTO dto) {
        ContratAssurance contrat = contratAssuranceRepository.findById(dto.getContratId())
                .orElseThrow(() -> new RuntimeException("Contrat not found"));

        Paiement paiement = Paiement.builder()
                .datePaiement(dto.getDatePaiement())
                .montant(dto.getMontant())
                .typePaiement(dto.getTypePaiement())
                .contratAssurance(contrat)
                .build();

        Paiement saved = paiementRepository.save(paiement);
        return paiementMapper.fromPaiement(saved);
    }

    @Override
    public List<PaiementDTO> listPaiements() {
        return paiementRepository.findAll()
                .stream()
                .map(paiementMapper::fromPaiement)
                .collect(Collectors.toList());
    }

    @Override
    public List<PaiementDTO> listPaiementsByContrat(Long contratId) {
        return paiementRepository.findByContratAssuranceId(contratId)
                .stream()
                .map(paiementMapper::fromPaiement)
                .collect(Collectors.toList());
    }

    @Override
    public void deletePaiement(Long id) {
        paiementRepository.deleteById(id);
    }
}