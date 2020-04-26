package com.javasampleapproach.solr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.javasampleapproach.solr.model.Customer;
import com.javasampleapproach.solr.repo.CustomerRepository;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages={"com.javasampleapproach.solr"})

public class SpringBootSolrApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void run(String... args) throws Exception {

		//customerRepository.deleteAll();

		// Store customers
		customerRepository.save(new Customer("1", "James", 150)); 
		/*customerRepository.save(Arrays.asList(new Customer("1", "Jack", 20), 
											new Customer("2", "Adam", 24),
											new Customer("3", "Kim", 27), 
											new Customer("4", "David", 30), 
											new Customer("5", "Peter", 21)));*/

		// Fetch all customers
		System.out.println("--------------------------------");
		System.out.println("Select all Customers:");
		System.out.println("--------------------------------");

		for (Customer product : this.customerRepository.findAll()) {
			System.out.println(product);
		}

		// Find customer by Name ends with 'm'
		System.out.println("--------------------------------");
		System.out.println("Find Customers that have names findByNameEndsWith");
		System.out.println("--------------------------------");

		/*for (Customer customer : this.customerRepository.findByNameEndsWith("J")) {
			System.out.println(customer);
		}*/
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootSolrApplication.class, args);
	}
}