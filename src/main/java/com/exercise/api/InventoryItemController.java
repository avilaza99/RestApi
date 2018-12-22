package com.exercise.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/inventory"})
@Api(value="RestAPI", description="Operations pertaining to inventory items")
public class InventoryItemController {

    @Autowired
    private InventoryItemService inventoryItemService;

    @GetMapping
    public ResponseEntity<List<InventoryItemDto>>getAllInventoryItems() {

        return new ResponseEntity<>(inventoryItemService.getAllInventoryItems(),HttpStatus.OK);
    }

    @GetMapping(path = {"/{inventoryItemId}"})
    public ResponseEntity<InventoryItemDto> getInventoryItemById(@PathVariable int inventoryItemId) {
        return new ResponseEntity<>(inventoryItemService.getInventoryItemById(inventoryItemId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveInventoryItem(@RequestBody InventoryItemDto inventoryItemDto) {
        if(inventoryItemService.saveInventoryItem(inventoryItemDto))
            return new ResponseEntity("Inventory Item succesfully created",HttpStatus.OK);
        return new ResponseEntity("ERROR: Please check with your local admin",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping(path = {"/{inventoryItemId}"})
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "The inventory item you were trying to reach is not found")
    })
    public ResponseEntity<InventoryItemDto> updateInventoryItem(@PathVariable int inventoryItemId, @RequestBody InventoryItemDto inventoryItemDto){
        InventoryItemDto inventoryItemDto2Return = inventoryItemService.updateInventoryItem(inventoryItemId,inventoryItemDto);
        if(inventoryItemDto2Return!=null)
            return new ResponseEntity<>(inventoryItemDto2Return,HttpStatus.OK);
        return new ResponseEntity<>(inventoryItemDto2Return,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path ={"/{inventoryItemId}"})
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "The inventory item you were trying to reach is not found")
    })
    public ResponseEntity deleteInventoryItem(@PathVariable int inventoryItemId) {
        if(inventoryItemService.deleteInventoryItem(inventoryItemId))
            return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
