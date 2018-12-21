package com.exercise.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/inventory"})
public class InventoryItemController {

    @Autowired
    private InventoryItemService inventoryItemService;

    @GetMapping
    public List<InventoryItemDto> getAllInventoryItems() {
        return inventoryItemService.getAllInventoryItems();
    }

    @GetMapping(path = {"/{inventoryItemId}"})
    public InventoryItemDto getInventoryItemById(@PathVariable int inventoryItemId) {
        return inventoryItemService.getInventoryItemById(inventoryItemId);
    }

    @PostMapping
    public void saveInventoryItem(@RequestBody InventoryItemDto inventoryItemDto) {
        inventoryItemService.saveInventoryItem(inventoryItemDto);
    }

    @PutMapping(path = {"/{inventoryItemId}"})
    public InventoryItemDto updateInventoryItem(@PathVariable int inventoryItemId, @RequestBody InventoryItemDto inventoryItemDto){
        return inventoryItemService.updateInventoryItem(inventoryItemId,inventoryItemDto);
    }

    @DeleteMapping(path ={"/{inventoryItemId}"})
    public void deleteInventoryItem(@PathVariable int inventoryItemId) {
        inventoryItemService.deleteInventoryItem(inventoryItemId);
    }

}
