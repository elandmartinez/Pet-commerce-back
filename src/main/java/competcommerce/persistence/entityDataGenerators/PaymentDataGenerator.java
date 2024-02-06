package competcommerce.persistence.entityDataGenerators;

import com.github.javafaker.Faker;
import competcommerce.persistence.entity.Payment;

import java.util.ArrayList;

public class PaymentDataGenerator {
    static Faker fake =  new Faker();

    static public ArrayList<Payment> generatePayments (int amountToGenerate, int totalOfPayments, int totalOfClients, int totalOfOrders) {
        if(amountToGenerate < 1) throw new RuntimeException("amount to generate param must be higher than 0");

        ArrayList<Payment> payments = new ArrayList<>();

        for(int i = 0; i < amountToGenerate; i++) {
            payments.add(new Payment(
                    fake.number().numberBetween(1, 10000), //paid amount
                    fake.number().numberBetween(1, totalOfPayments), // payment method id, will be one while actual workflow is finished
                    fake.number().numberBetween(1, totalOfClients), // client id, will be one while actual workflow is finished
                    fake.number().numberBetween(1, totalOfOrders) // order id, will be one while actual workflow is finished
            ));
        }

        return payments;
    }
}
