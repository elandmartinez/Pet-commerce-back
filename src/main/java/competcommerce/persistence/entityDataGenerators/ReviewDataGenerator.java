package competcommerce.persistence.entityDataGenerators;

import com.github.javafaker.Faker;
import competcommerce.persistence.entity.Review;

import java.util.ArrayList;

public class ReviewDataGenerator {
    private static Faker fake = new Faker();

    public static ArrayList<Review> generateReviews(int amountToGenerate, int totalOfProducts) {
        if(amountToGenerate < 1) throw new RuntimeException("amount to generate param must be higher than 0");

        ArrayList<Review> newReviews = new ArrayList<>();

        for (int i = 0; i < amountToGenerate; i++) {
            newReviews.add(new Review(
                    (short) fake.number().numberBetween(0,11),
                    fake.lorem().characters(50),
                    fake.number().numberBetween(1, totalOfProducts)
            ));
        }

        return newReviews;
    }
}
