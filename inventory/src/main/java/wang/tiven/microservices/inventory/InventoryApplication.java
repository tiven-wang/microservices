package wang.tiven.microservices.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@SpringBootApplication
public class InventoryApplication {

	private static Logger log = LoggerFactory.getLogger(InventoryApplication.class);

	private static int books = 10;

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

	@RequestMapping(value = "/check-out")
	public int checkOut(@RequestParam String book) {
		log.info(book);
		return --books;
	}

	@RequestMapping(value = "/check-in")
	public int checkIn(@RequestParam String book) {
		log.info(book);
		return ++books;
	}
}
