package competcommerce.web.controller;

import competcommerce.persistence.entity.Address;
import competcommerce.service.AddressService;
import competcommerce.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {
    private final AddressService addressService;
    private final ClientService clientService;

    @Autowired
    AddressController (AddressService addressService, ClientService clientService) {
        this.addressService = addressService;
        this.clientService = clientService;
    }

    @GetMapping("/get")
    public ResponseEntity getAll () {
        return ResponseEntity.ok(this.addressService.getAll());
    }

    @GetMapping("/get/{addressId}")
    public ResponseEntity getBydId(@PathVariable int addressId) {
        return ResponseEntity.ok(this.addressService.getById(addressId));
    }

    @GetMapping("/get-by-client-id/{clientId}")
    public ResponseEntity getByClientId (@PathVariable String clientId) {
        return ResponseEntity.ok(this.addressService.getByClientId(clientId));
    }

    @PostMapping("/post")
    public ResponseEntity postMany (@RequestBody List<Address> newAddresses) {
        this.addressService.addMany(newAddresses);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/update-address")
    public ResponseEntity update (@RequestBody Address address) {
        this.addressService.update(address);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/delete/{addressId}")
    public ResponseEntity deleteProduct(@PathVariable int addressId) {
        this.addressService.deleteById(addressId);
        return ResponseEntity.ok().build();
    }
}
