package com.exercise.api;

public class InventoryItemDto {

    Integer inventoryItemId;
    String inventoryItemName;

    public InventoryItemDto(Integer inventoryItemId, String inventoryItemName) {
        this.inventoryItemId = inventoryItemId;
        this.inventoryItemName = inventoryItemName;
    }

    public InventoryItemDto() {
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