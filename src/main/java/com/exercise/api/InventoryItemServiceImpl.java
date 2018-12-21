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
    public void saveInventoryItem(InventoryItemDto inventoryItemDto) {
        repository.save(InventoryItemConverter.dtoToEntity(inventoryItemDto));
    }

    @Override
    public List<InventoryItemDto> getAllInventoryItems() {
        return repository.findAll().stream().map(InventoryItemConverter::entityToDto).collect(Collectors.toList());
    }

    @Override
    public InventoryItemDto updateInventoryItem(Integer inventoryItemId, InventoryItemDto inventoryItemDto) {
        if(repository.existsById(inventoryItemId))
        {
            InventoryItem inventoryItem = repository.getOne(inventoryItemId);
            inventoryItemDto.setInventoryItemId(inventoryItemId);
            repository.save(InventoryItemConverter.dtoToEntity(inventoryItemDto));
        }
        return inventoryItemDto;
    }

    @Override
    public  void deleteInventoryItem(Integer inventoryItemId){
        InventoryItem inventoryItem = repository.getOne(inventoryItemId);
        if(inventoryItem!=null)
            repository.delete(inventoryItem);
    }
}
