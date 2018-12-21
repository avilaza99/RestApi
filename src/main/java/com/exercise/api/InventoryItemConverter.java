package com.exercise.api;

public class InventoryItemConverter {

    public static InventoryItem dtoToEntity(InventoryItemDto inventoryItemDto) {
        InventoryItem inventoryItem = new InventoryItem(inventoryItemDto.getInventoryItemName());
        inventoryItem.setInventoryItemId(inventoryItemDto.getInventoryItemId());
        return inventoryItem;
    }

    public static InventoryItemDto entityToDto(InventoryItem inventoryItem) {
        InventoryItemDto inventoryItemDto = new InventoryItemDto(inventoryItem.getInventoryItemId(), inventoryItem.getInventoryItemName());
        return inventoryItemDto;
    }
}
