package com.exercise.api;

public class InventoryItemConverter {

    public static InventoryItem dtoToEntity(InventoryItemDto inventoryItemDto) {
        InventoryItem inventoryItem = new InventoryItem(inventoryItemDto.getInventoryItemName(),inventoryItemDto.getInventoryItemAmount(),inventoryItemDto.getInventoryItemCode());
        inventoryItem.setInventoryItemId(inventoryItemDto.getInventoryItemId());
        return inventoryItem;
    }

    public static InventoryItemDto entityToDto(InventoryItem inventoryItem) {
        return new InventoryItemDto(inventoryItem.getInventoryItemId(), inventoryItem.getInventoryItemName(),
                inventoryItem.getInventoryItemAmount(),inventoryItem.getInventoryItemCode());
    }
}
