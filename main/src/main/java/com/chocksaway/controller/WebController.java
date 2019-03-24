package com.chocksaway.controller;

import com.chocksaway.model.Customer;
import com.chocksaway.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

@RestController
public class WebController {
    @Autowired
    CustomerRepository repository;

    @RequestMapping("/save")
    public String process(){
        // save a single Customer
        repository.save(new Customer("Miles", "Davis", LocalDate.now()));
        repository.save(new Customer("Sid", "Jones", LocalDate.now()));
        repository.save(new Customer("Arther", "Bradshaw",
                LocalDate.of(2014, 6, 30)));
        repository.save(new Customer("Sally", "Willis", LocalDate.now()));
        repository.save(new Customer("Winston", "Davis", LocalDate.now()));

        return "Done";
    }


    @RequestMapping("/findall")
    public String findAll() {
        String result = "";

        for(Customer cust : repository.findAll()){
            result += cust.toString() + "<br>";
        }

        return result;
    }

    @RequestMapping("/findbefore")
    public String findBetween() {
        String result = "";
        LocalDate now = LocalDate.now();

        for(Customer cust : repository.findByDobBefore(now)){
            result += cust.toString() + "<br>";
        }

        return result;
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id) {
        Optional<Customer> customer  = repository.findById(id);
        String result = "";
        if (customer.isPresent()) {
            result = customer.get().toString();
        }
        return result;
    }

    @RequestMapping("/findbylastname")
    public String fetchDataByLastName(@RequestParam("lastname") String lastName) {
        String result = "";

        for(Customer cust: repository.findByLastName(lastName)){
            result += cust.toString() + "<br>";
        }

        return result;
    }
}

