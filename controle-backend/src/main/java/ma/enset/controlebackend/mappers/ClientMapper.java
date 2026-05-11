package ma.enset.controlebackend.mappers;

import ma.enset.controlebackend.dto.ClientDTO;
import ma.enset.controlebackend.entities.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientDTO fromClient(Client client) {
        return ClientDTO.builder()
                .id(client.getId())
                .nom(client.getNom())
                .email(client.getEmail())
                .build();
    }

    public Client fromClientDTO(ClientDTO clientDTO) {
        return Client.builder()
                .id(clientDTO.getId())
                .nom(clientDTO.getNom())
                .email(clientDTO.getEmail())
                .build();
    }
}