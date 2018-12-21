package com.exercise.api;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class InventoryItem implements Serializable{

    private static final long serialVersionUID = 0x62A6DA99AABDA8A8L;

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer inventoryItemId;
    @Column private String inventoryItemName;
    @Column private BigDecimal inventoryItemAmount;
    @Column private String inventoryItemCode;

    public InventoryItem(String inventoryItemName, BigDecimal inventoryItemAmount, String inventoryItemCode) {
        this.inventoryItemName = inventoryItemName;
        this.inventoryItemAmount = inventoryItemAmount;
        this.inventoryItemCode = inventoryItemCode;
    }

    public InventoryItem (){}

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

    public BigDecimal getInventoryItemAmount() {
        return inventoryItemAmount;
    }

    public void setInventoryItemAmount(BigDecimal inventoryItemAmount) {
        this.inventoryItemAmount = inventoryItemAmount;
    }

    public String getInventoryItemCode() {
        return inventoryItemCode;
    }

    public void setInventoryItemCode(String inventoryItemCode) {
        this.inventoryItemCode = inventoryItemCode;
    }
}