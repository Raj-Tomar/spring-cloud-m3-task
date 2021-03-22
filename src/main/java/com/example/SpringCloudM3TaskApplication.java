package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class SpringCloudM3TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudM3TaskApplication.class, args);
	}

	@Bean
	public TollProcessingTask tollProcessingTask() {
		return new TollProcessingTask();
	}

	public class TollProcessingTask implements CommandLineRunner {

		@Override
		public void run(String... args) throws Exception {
			// Parameters stationId, license plate, timestamp
			if (null != args) {
				System.out.println("Parameters: " + args.length);

				String stationId = args[1];
				String licensePlate = args[2];
				String timstamp = args[3];

				System.out.println("\nStation ID : " + stationId + "\nLicense Plate : " + licensePlate
						+ "\nTimestampe : " + timstamp);
			}
		}

	}
}
