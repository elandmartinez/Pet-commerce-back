package competcommerce.persistence.entityDataGenerators;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import competcommerce.persistence.entity.Product;

public class ProductDataGenerator {
    static Faker fake = new Faker();

    public static ArrayList<Product> generateProducts (int amountToGenerate) {
        if(amountToGenerate < 1) throw new RuntimeException("amount to generate param must be higher than 0");

        ArrayList<Product> products = new ArrayList<>();
        for (int i = 0; i < amountToGenerate; i++) {
            products.add(new Product(
                    String.valueOf(fake.name().fullName()), //name
                    String.valueOf(fake.lorem().characters(50)), //description
                    fake.number().numberBetween(1, 99999999), // price
                    ("height: " + fake.number().numberBetween(1, 10) + "cm, width: " + fake.number().numberBetween(1, 10) + "cm, deep: " + fake.number().numberBetween(1, 10)  + " cm"),
                    //dimensions
                    formatDateAndTimeToLocalDate(fake.date()), //expiring date
                    formatDateAndTimeToLocalDate(fake.date()), //elaboration date
                    String.valueOf(fake.name().fullName()), //provider
                    String.valueOf(fake.lorem().characters(50)),//category
                    fake.number().numberBetween(1, 99999999),//stock
                    String.valueOf(fake.lorem().characters(50))//urlImage
            ));
        }

        return products;
    }

    private static LocalDate formatDateAndTimeToLocalDate(DateAndTime date) {
        SimpleDateFormat simpleDateFormatter = new SimpleDateFormat("MM/dd/yyyy");
        String simpleFormattedDate = simpleDateFormatter.format(date.birthday());

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        // Parse the string and obtain a LocalDate
        return LocalDate.parse(simpleFormattedDate, dateFormatter);
    }
}
