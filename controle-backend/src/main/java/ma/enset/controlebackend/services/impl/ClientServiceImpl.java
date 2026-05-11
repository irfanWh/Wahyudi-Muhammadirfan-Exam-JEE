package ma.enset.controlebackend.services.impl;

import lombok.AllArgsConstructor;
import ma.enset.controlebackend.dto.ClientDTO;
import ma.enset.controlebackend.entities.Client;
import ma.enset.controlebackend.mappers.ClientMapper;
import ma.enset.controlebackend.repositories.ClientRepository;
import ma.enset.controlebackend.services.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private ClientMapper clientMapper;

    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client client = clientMapper.fromClientDTO(clientDTO);
        Client savedClient = clientRepository.save(client);
        return clientMapper.fromClient(savedClient);
    }

    @Override
    public ClientDTO getClient(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return clientMapper.fromClient(client);
    }

    @Override
    public List<ClientDTO> listClients() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::fromClient)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        client.setNom(clientDTO.getNom());
        client.setEmail(clientDTO.getEmail());

        Client updatedClient = clientRepository.save(client);
        return clientMapper.fromClient(updatedClient);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}