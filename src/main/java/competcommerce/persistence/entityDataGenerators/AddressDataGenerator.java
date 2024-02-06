package competcommerce.persistence.entityDataGenerators;

import com.github.javafaker.Faker;
import competcommerce.persistence.entity.Address;
import competcommerce.service.AddressService;

import java.util.ArrayList;

public class AddressDataGenerator {
    private static Faker fake = new Faker();

    public static ArrayList<Address> generateAddresses (int amountToGenerate, int totalAmountOfClients) {
        if(amountToGenerate < 1) throw new RuntimeException("amount to generate param must be higher than 0");

        ArrayList<Address> newAddresses = new ArrayList<>();

        for(int i = 0; i < amountToGenerate; i++) {
            Address newAddress = new Address(
                    fake.address().streetAddress(),
                    fake.address().city(),
                    fake.address().state(),
                    fake.address().country(),
                    fake.number().numberBetween(1, totalAmountOfClients)
            );
            newAddresses.add(newAddress);
        }

        return newAddresses;
    }
}
