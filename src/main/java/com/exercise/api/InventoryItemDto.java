package com.exercise.api;

import java.math.BigDecimal;

public class InventoryItemDto {

    Integer inventoryItemId;
    String inventoryItemName;
    BigDecimal inventoryItemAmount;
    String inventoryItemCode;

    public InventoryItemDto(Integer inventoryItemId, String inventoryItemName, BigDecimal inventoryItemAmount, String inventoryItemCode) {
        this.inventoryItemId = inventoryItemId;
        this.inventoryItemName = inventoryItemName;
        this.inventoryItemAmount = inventoryItemAmount;
        this.inventoryItemCode = inventoryItemCode;
    }

    public InventoryItemDto(){}

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