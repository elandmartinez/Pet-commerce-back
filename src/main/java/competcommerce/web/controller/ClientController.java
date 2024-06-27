package competcommerce.web.controller;

import competcommerce.persistence.entity.Client;
import competcommerce.persistence.entityDataGenerators.ClientDataGenerator;
import competcommerce.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/get")
    public ResponseEntity get () {
        return ResponseEntity.ok(this.clientService.getAll());
    }

    @GetMapping("/get/{clientId}")
    public ResponseEntity getOne (@PathVariable int clientId) {
        return ResponseEntity.ok(this.clientService.getById(clientId));
    }

    @GetMapping("/get-client/{clientName}")
    public ResponseEntity getOne (@PathVariable String clientName) {
        return ResponseEntity.ok(this.clientService.getByName(clientName));
    }

    @PostMapping("/post/{amountToGenerate}")
    public ResponseEntity post (@PathVariable int amountToGenerate) {
        ArrayList<Client> newClients = ClientDataGenerator.generateClients(amountToGenerate);
        this.clientService.addMany(newClients);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/post-client")
    public ResponseEntity postClient(@RequestBody Client client){
        this.clientService.addOne(client);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update-client")
    public ResponseEntity update(@RequestBody Client client){
        this.clientService.addOne(client);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{clientId}")
    public ResponseEntity deleteOne (@PathVariable int clientId) {
        this.clientService.deleteClient(clientId);

        return ResponseEntity.ok().build();
    }
}
