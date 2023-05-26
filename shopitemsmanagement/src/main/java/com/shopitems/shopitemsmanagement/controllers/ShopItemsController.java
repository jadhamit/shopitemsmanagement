package com.shopitems.shopitemsmanagement.controllers;


import com.shopitems.shopitemsmanagement.dto.ItemRequestDto;
import com.shopitems.shopitemsmanagement.dto.ItemResponseDto;
import com.shopitems.shopitemsmanagement.services.ShopItemsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@Slf4j
public class ShopItemsController {

    @Autowired
    private ShopItemsService shopItemsService;

    @GetMapping("/item/{id}")
    public ResponseEntity<ItemResponseDto> getItemById(@PathVariable long id) {
        ItemResponseDto itemResponseDto = shopItemsService.getItemById(id);
        return new ResponseEntity<>(itemResponseDto, HttpStatus.OK);
    }

    @PostMapping("/item")
    public ResponseEntity<ItemResponseDto> createItem(@RequestBody ItemRequestDto itemRequestDto) {
        Optional<ItemResponseDto> itemResponseDtoOptional = shopItemsService.createItem(itemRequestDto);
        ResponseEntity<ItemResponseDto> responseEntity = null;
        if (itemResponseDtoOptional.isPresent()) {
            responseEntity = new ResponseEntity<>(itemResponseDtoOptional.get(), HttpStatus.CREATED);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        return responseEntity;
    }

    @PostMapping("/items")
    public List<ResponseEntity<ItemResponseDto>> createMultipleItems(@RequestBody List<ItemRequestDto> itemsRequestDto) {
        List<ItemResponseDto> itemsResponseDto = shopItemsService.createMultipleItems(itemsRequestDto);
        List<ResponseEntity<ItemResponseDto>> responseEntityList = new ArrayList<>();
        for (ItemResponseDto itemResponseDto : itemsResponseDto) {
            if (Objects.nonNull(itemResponseDto)) {
                responseEntityList.add(new ResponseEntity<>(itemResponseDto, HttpStatus.CREATED));
            }
        }
        return responseEntityList;
    }


    @DeleteMapping("/item/{id}")
    public ResponseEntity<ItemResponseDto> deleteItem(@PathVariable long id) {
        shopItemsService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/items")
    public ResponseEntity<List<ItemResponseDto>> getAllItems() {
        List<ItemResponseDto> itemsResponseDto = shopItemsService.getAllItems();
        return new ResponseEntity<>(itemsResponseDto, HttpStatus.OK);
    }

    @PutMapping("/item/{id}")
    public ResponseEntity<ItemResponseDto> updateItem(@PathVariable long id, @RequestBody ItemRequestDto itemRequestDto) {
        Optional<ItemResponseDto> itemResponseDto = shopItemsService.updateItem(id, itemRequestDto);
        return new ResponseEntity<>(itemResponseDto.get(), HttpStatus.NO_CONTENT);
    }

}
