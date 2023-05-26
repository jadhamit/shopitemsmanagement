package com.shopitems.shopitemsmanagement.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopitems.shopitemsmanagement.dto.ItemRequestDto;
import com.shopitems.shopitemsmanagement.dto.ItemResponseDto;
import com.shopitems.shopitemsmanagement.entity.Item;
import com.shopitems.shopitemsmanagement.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ShopItemsService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ItemRepository itemRepository;

    public Optional<ItemResponseDto> createItem(ItemRequestDto itemRequestDto) {
        Item item = objectMapper.convertValue(itemRequestDto, Item.class);
        log.info("Create a new Item::{}", item);
        itemRepository.save(item);
        return Optional.ofNullable(
                ItemResponseDto.builder().id(item.getId()).name(item.getName()).price(item.getPrice()).build());
    }

    public ItemResponseDto getItemById(long id){
        return objectMapper.convertValue(itemRepository.findById(id), ItemResponseDto.class);
    }

    public void deleteItem(long id) {
        itemRepository.deleteById(id);
    }

    public List<ItemResponseDto> getAllItems() {
        List<Item> itemsList = itemRepository.findAll();
        return itemsList.stream().map(item -> objectMapper.convertValue(item, ItemResponseDto.class)).collect(Collectors.toList());
    }

    public List<ItemResponseDto> createMultipleItems(List<ItemRequestDto> itemsRequestDto) {
        List<ItemResponseDto> itemsResponseDto = new ArrayList<>();
        for (ItemRequestDto requestDto: itemsRequestDto) {
            itemsResponseDto.add(createItem(requestDto).get());
        }
        return itemsResponseDto;
    }

    public Optional<ItemResponseDto> updateItem(long id, ItemRequestDto itemRequestDto) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if(itemOptional.isPresent()){
            Item item = objectMapper.convertValue(itemRequestDto, Item.class);
            item.setId(itemOptional.get().getId());
            return Optional.ofNullable(objectMapper.convertValue(itemRepository.save(item), ItemResponseDto.class));
        }
        return createItem(itemRequestDto);
    }
}
