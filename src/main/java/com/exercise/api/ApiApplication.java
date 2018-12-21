package com.exercise.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.PostConstruct;
import java.math.BigDecimal;


@SpringBootApplication
public class ApiApplication {

    @Autowired InventoryItemRepository repository;

    public static void main(String[] args) {

        SpringApplication.run(ApiApplication.class, args);
    }

    @PostConstruct
    public void setupDbWithData(){
        InventoryItem inventoryItem= new InventoryItem("item01",new BigDecimal(10),"1item");
        repository.save(inventoryItem);
    }

}

