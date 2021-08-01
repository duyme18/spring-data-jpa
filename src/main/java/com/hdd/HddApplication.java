package com.hdd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HddApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(HddApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HddApplication.class, args);
	}

	@Autowired
	private ProductRepository productRepository;


	@Override
	public void run(String... args) {
		log.info("HddApplication...");

		productRepository.save(new Product("Computer"));
		productRepository.save(new Product("Phone"));
		productRepository.save(new Product("Book"));

		System.out.println("\nfindAll()");
		productRepository.findAll().forEach(System.out::println);

		System.out.println("\nfindById(1L)");
		productRepository.findById(1l).ifPresent(System.out::println);

		System.out.println("\nfindByName('Computer')");
		productRepository.findByName("Computer").forEach(System.out::println);
	}
}
