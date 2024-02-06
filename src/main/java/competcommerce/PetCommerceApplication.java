package competcommerce;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class PetCommerceApplication {
	public static void main(String[] args) {
		SpringApplication.run(PetCommerceApplication.class, args);
		// TODO: make a method on each dependent entities services so when they have to be assigned
		// to a antoher entity (like address to client) is donde randomly and works perfectly with the
		// existing independent entities (client)
	}
}
