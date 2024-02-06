package competcommerce.persistence.entityDataGenerators;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import competcommerce.persistence.entity.Pet;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PetDataGenerator {
    private static Faker fake = new Faker();

    public static ArrayList<Pet> generatePets(int amountToGenerate, int totalOfClients) {
        if(amountToGenerate < 1) throw new RuntimeException("amount to generate param must be higher than 0");

        ArrayList<Pet> newPets = new ArrayList<>();
        for(int i = 0; i < amountToGenerate; i++) {
            newPets.add(new Pet(
                    fake.pokemon().name(),
                    formatDateAndTimeToLocalDate(fake.date()),
                    fake.lorem().characters(8),
                    fake.number().numberBetween(1, totalOfClients)
            ));
        }

        return newPets;
    }

    private static LocalDate formatDateAndTimeToLocalDate(DateAndTime date) {
        SimpleDateFormat simpleDateFormatter = new SimpleDateFormat("MM/dd/yyyy");
        String simpleFormattedDate = simpleDateFormatter.format(date.birthday());

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        // Parse the string and obtain a LocalDate
        return LocalDate.parse(simpleFormattedDate, dateFormatter);
    }
}
