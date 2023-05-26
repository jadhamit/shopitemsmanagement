package com.shopitems.shopitemsmanagement;

import com.shopitems.shopitemsmanagement.controllers.ShopItemsController;
import com.shopitems.shopitemsmanagement.dto.ItemResponseDto;
import com.shopitems.shopitemsmanagement.services.ShopItemsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class ShopItemControllerTest {

    @InjectMocks
    private ShopItemsController shopItemsController;

    @Mock
    private ShopItemsService shopItemsService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(ShopItemControllerTest.class);
    }

    @Test
    public void testGetItemById(){
        Mockito.when(shopItemsService.getItemById(1l)).
                thenReturn(ItemResponseDto.builder().id(1).name("Apple").price(new BigDecimal(100)).build());
        ResponseEntity<ItemResponseDto> itemResponseDtoResponseEntity = shopItemsController.getItemById(1l);

        assertNotNull(itemResponseDtoResponseEntity);

        assertEquals(HttpStatus.OK, itemResponseDtoResponseEntity.getStatusCode());

        assertEquals("Apple", itemResponseDtoResponseEntity.getBody().getName());
        assertEquals(100 , itemResponseDtoResponseEntity.getBody().getPrice().intValue());
        assertEquals(1l, itemResponseDtoResponseEntity.getBody().getId());

    }

}
