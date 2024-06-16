package ch.timo.f1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Level;

@SpringBootApplication
public class F1M226bApplication {

	public static void main(String[] args) {

		try {
			Log log = new Log("f1_log.txt");

			log.logger.setLevel(Level.ALL);
			log.logger.info("Starting F1M226bApplication...");

			SpringApplication.run(F1M226bApplication.class, args);

			log.logger.info("F1M226bApplication started successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
