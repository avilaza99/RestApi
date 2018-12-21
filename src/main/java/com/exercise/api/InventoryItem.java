package com.exercise.api;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class InventoryItem implements Serializable{

    private static final long serialVersionUID = 0x62A6DA99AABDA8A8L;

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer inventoryItemId;
    @Column
    private String inventoryItemName;

    public InventoryItem() {
    }

    public InventoryItem(String inventoryItemName) {
        this.inventoryItemName = inventoryItemName;
    }

    public Integer getInventoryItemId() {

        return inventoryItemId;
    }

    public void setInventoryItemId(Integer inventoryItemId) {

        this.inventoryItemId = inventoryItemId;
    }

    public String getInventoryItemName() {

        return inventoryItemName;
    }

    public void setInventoryItemName(String inventoryItemName) {

        this.inventoryItemName = inventoryItemName;
    }

}