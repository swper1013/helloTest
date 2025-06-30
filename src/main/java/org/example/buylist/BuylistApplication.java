package org.example.buylist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BuylistApplication {

    public static void main(String[] args) {

        SpringApplication.run(BuylistApplication.class, args);
        System.out.println("Spring Boot Start --><____><____><--");
    }

}
