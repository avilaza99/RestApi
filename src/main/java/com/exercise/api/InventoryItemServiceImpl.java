package com.exercise.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryItemServiceImpl implements InventoryItemService {

    @Autowired
    private InventoryItemRepository repository;

    @Override
    public InventoryItemDto getInventoryItemById(Integer inventoryItemId) {
        return InventoryItemConverter.entityToDto(repository.getOne(inventoryItemId));
    }

    @Override
    public boolean saveInventoryItem(InventoryItemDto inventoryItemDto) {
        try {
            repository.save(InventoryItemConverter.dtoToEntity(inventoryItemDto));
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    @Override
    public List<InventoryItemDto> getAllInventoryItems() {
        return repository.findAll().stream().map(InventoryItemConverter::entityToDto).collect(Collectors.toList());
    }

    @Override
    public InventoryItemDto updateInventoryItem(Integer inventoryItemId, InventoryItemDto inventoryItemDto) {
        try{
            InventoryItem inventoryItem = repository.getOne(inventoryItemId);
            inventoryItemDto.setInventoryItemId(inventoryItemId);
            repository.save(InventoryItemConverter.dtoToEntity(inventoryItemDto));
            return inventoryItemDto;
        }catch(Exception ex){
            return null;
        }
    }

    @Override
    public  boolean deleteInventoryItem(Integer inventoryItemId){
        try {
            repository.deleteById(inventoryItemId);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
}
