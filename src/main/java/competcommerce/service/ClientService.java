package competcommerce.service;

import competcommerce.persistence.entity.Client;
import competcommerce.persistence.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final UserService userService;

    @Autowired
    public ClientService (ClientRepository clientRepository, UserService userService) {
        this.clientRepository = clientRepository;
        this.userService = userService;
    }

    @Secured("ROLE_ADMIN")
    public List<Client> getAll () {
        return this.clientRepository.findAll();
    }

    public Optional<Client> getById (int clientId) {
        if(!this.clientRepository.existsById(clientId)) {
            throw new RuntimeException("There's no records for the id provided");
        }
        return this.clientRepository.findById(clientId);
    }
    public void addMany(List<Client> clients) {
        this.clientRepository.saveAll(clients);
    }

    public List<Client> getByName(String name) {
            return this.clientRepository.findAllByNameContainingIgnoreCase(name);
    }

    public void addOne (Client client) {
        this.clientRepository.save(client);
        this.userService.createUserFromClient(client);
    }

    public void deleteClient (int clientId) {
        if(this.clientRepository.existsById(clientId)) {
            this.clientRepository.deleteById(clientId);
        } else {
            throw new RuntimeException("The id provided doesn't exists, the id was: " + clientId);
        }
    }
}
