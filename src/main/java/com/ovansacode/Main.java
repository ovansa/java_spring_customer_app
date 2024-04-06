package com.ovansacode;

import com.ovansacode.customer.Customer;
import com.ovansacode.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository) {
        return args -> {
            Customer ovansa = new Customer("Ovansa", "ovansa@gmail.com", 21);
            Customer onize = new Customer("Onize", "onize@gmail.com", 22);
            Customer wifey
                    = new Customer("Wifey", "wifey@gmail.com", 23);

            List<Customer> customers = List.of(ovansa, onize, wifey);
            customerRepository.saveAll(customers);
            System.out.println("Customers inserted: " + customerRepository.count());
        };
    }
}
