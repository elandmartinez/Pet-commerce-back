package competcommerce.service;

import competcommerce.persistence.entity.Address;
import competcommerce.persistence.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService (AddressRepository addressRepository) {this.addressRepository = addressRepository;}

    public List<Address> getAll() {
        return this.addressRepository.findAll();
    }

    public Optional<Address> getById(int addressId) {
        if(!this.addressRepository.existsById(addressId)) {
            throw new RuntimeException("There's no records for the id provided");
        }
        return this.addressRepository.findById(addressId);
    }

    public void addMany(ArrayList<Address> addresses) {
        this.addressRepository.saveAll(addresses);
    }

    public void addOne(Address newAddress) {
        this.addressRepository.save(newAddress);
    }

    public void update(Address newAddressUpdate) {
        this.addressRepository.save(newAddressUpdate);
    }

    public void deleteById(int addressId) {
        this.addressRepository.deleteById(addressId);
    }
}
