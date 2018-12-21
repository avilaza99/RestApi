package com.exercise.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.PostConstruct;


@SpringBootApplication
public class ApiApplication {

    @Autowired InventoryItemRepository repository;

    public static void main(String[] args) {

        SpringApplication.run(ApiApplication.class, args);
    }

    @PostConstruct
    public void setupDbWithData(){
        InventoryItem inventoryItem= new InventoryItem("Jonathan");
        //inventoryItem = repository.save(inventoryItem);
        repository.saveAndFlush(inventoryItem);
    }

}

