package competcommerce.persistence.entityDataGenerators;

import com.github.javafaker.Faker;
import competcommerce.persistence.entity.PaymentMethod;

import java.util.ArrayList;

public class PaymentMethodDataGenerator {
    static Faker fake =  new Faker();

    public static ArrayList<PaymentMethod> generatePayments (int amountToGenerate, int totalOfClients) {
        if(amountToGenerate < 1) throw new RuntimeException("amount to generate param must be higher than 0");

        ArrayList<PaymentMethod> payments = new ArrayList<>();

        for(int i = 0; i < amountToGenerate; i++) {
            payments.add(new PaymentMethod(
                    fake.number().randomNumber(16, true), // card number
                    generateExpirationDate(fake), // card expiration date
                    (short) fake.number().numberBetween(000, 999), // card code
                    fake.name().fullName(),
                    fake.number().numberBetween(1, totalOfClients)
            ));
        }

        return payments;
    }

    private static String generateExpirationDate (Faker fake) {
        return String.valueOf(fake.number().numberBetween(1, 31)) + "/" + String.valueOf(fake.number().numberBetween(1, 12));
    }
}
