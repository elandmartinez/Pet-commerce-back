package competcommerce.persistence.entityDataGenerators;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import competcommerce.persistence.entity.Order;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class OrderDataGenerator {
    static Faker fake = new Faker();

    public static ArrayList<Order> generateOrders (int amountToGenerate, int totalOfClients, int totalOfPayments) {
        if(amountToGenerate < 1) throw new RuntimeException("amount to generate param must be higher than 0");

        ArrayList<Order> orders = new ArrayList<>();

        for(int i = 0; i < amountToGenerate; i++){
            orders.add(new Order(
                    formatDateAndTimeToLocalDate(fake.date()),//date of purchase
                    fake.lorem().characters(10), //status of purchase
                    fake.number().numberBetween(1, totalOfClients), // client id, it will be one meanwhile we build the real workflow of this
                    fake.number().numberBetween(1,10)
            ));
        }

        return orders;
    }

    private static LocalDate formatDateAndTimeToLocalDate(DateAndTime date) {
        SimpleDateFormat simpleDateFormatter = new SimpleDateFormat("MM/dd/yyyy");
        String simpleFormattedDate = simpleDateFormatter.format(date.birthday());

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        // Parse the string and obtain a LocalDate
        return LocalDate.parse(simpleFormattedDate, dateFormatter);
    }
}
