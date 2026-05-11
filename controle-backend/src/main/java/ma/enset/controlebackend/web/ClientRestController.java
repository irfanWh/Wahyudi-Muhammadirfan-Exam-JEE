package ma.enset.controlebackend.web;

import lombok.AllArgsConstructor;
import ma.enset.controlebackend.dto.ClientDTO;
import ma.enset.controlebackend.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@AllArgsConstructor
@CrossOrigin("*")
public class ClientRestController {

    private ClientService clientService;

    @GetMapping
    public List<ClientDTO> listClients() {
        return clientService.listClients();
    }

    @GetMapping("/{id}")
    public ClientDTO getClient(@PathVariable Long id) {
        return clientService.getClient(id);
    }

    @PostMapping
    public ClientDTO saveClient(@RequestBody ClientDTO clientDTO) {
        return clientService.saveClient(clientDTO);
    }

    @PutMapping("/{id}")
    public ClientDTO updateClient(@PathVariable Long id,
                                  @RequestBody ClientDTO clientDTO) {
        return clientService.updateClient(id, clientDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}