package competcommerce.persistence.entityDataGenerators;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import competcommerce.persistence.entity.Client;
import competcommerce.persistence.entity.Client;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ClientDataGenerator {
    static Faker fake = new Faker();

    public static ArrayList<Client> generateClients (int amountToGenerate) {
        if(amountToGenerate < 1) throw new RuntimeException("amount to generate param must be higher than 0");

        ArrayList<Client> clients = new ArrayList<>();
        for (int i  = 0; i < amountToGenerate; i++){
            clients.add(new Client(
                    //name, email, phone, nationalCode
                    fake.name().fullName(), //name
                    fake.name().firstName() + "@gmail.com",
                    fake.number().numberBetween(1, 999999999), // price
                    (short) fake.number().numberBetween(1, 199)
            ));
        }

        return clients;
    }
}
