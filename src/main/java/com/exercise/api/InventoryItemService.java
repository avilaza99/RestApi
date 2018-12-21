package com.exercise.api;

import java.util.List;

public interface InventoryItemService {

    InventoryItemDto getInventoryItemById(Integer inventoryItemId);
    boolean saveInventoryItem(InventoryItemDto inventoryItemDto);
    List<InventoryItemDto> getAllInventoryItems();
    InventoryItemDto updateInventoryItem(Integer inventoryItemId,InventoryItemDto inventoryItemDto);
    boolean deleteInventoryItem(Integer inventoryItemId);
}