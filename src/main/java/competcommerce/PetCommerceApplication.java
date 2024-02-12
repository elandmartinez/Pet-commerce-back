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
	}
}
