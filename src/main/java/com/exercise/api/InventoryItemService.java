package com.exercise.api;

import java.util.List;

public interface InventoryItemService {

    InventoryItemDto getInventoryItemById(Integer inventoryItemId);
    void saveInventoryItem(InventoryItemDto inventoryItemDto);
    List<InventoryItemDto> getAllInventoryItems();
    InventoryItemDto updateInventoryItem(Integer inventoryItemId,InventoryItemDto inventoryItemDto);
    void deleteInventoryItem(Integer inventoryItemId);
}