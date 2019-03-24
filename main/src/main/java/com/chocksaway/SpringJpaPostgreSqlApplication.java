package com.chocksaway;

import com.chocksaway.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Author milesd on 22/03/2019.
 */

@SpringBootApplication
public class SpringJpaPostgreSqlApplication implements CommandLineRunner{

    @Autowired
    CustomerRepository repository;

    public static void main(String[] args){
        SpringApplication.run(SpringJpaPostgreSqlApplication.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {
        // clear all record if existed before do the tutorial with new data
        repository.deleteAll();
    }
}