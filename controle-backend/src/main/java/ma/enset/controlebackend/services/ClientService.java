package ma.enset.controlebackend.services;

import ma.enset.controlebackend.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    ClientDTO saveClient(ClientDTO clientDTO);
    ClientDTO getClient(Long id);
    List<ClientDTO> listClients();
    ClientDTO updateClient(Long id, ClientDTO clientDTO);
    void deleteClient(Long id);
}