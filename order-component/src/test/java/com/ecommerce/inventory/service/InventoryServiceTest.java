package com.ecommerce.inventory.service;

import com.ecommerce.core.common.Price;
import com.ecommerce.core.inventory.Stock;
import com.ecommerce.inventory.repository.InventoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InventoryServiceTest {

    @Mock
    private InventoryRepository inventoryRepository;

    @InjectMocks
    private InventoryService inventoryService;

    @Test
    public void shouldFillUpStockAndReturnBarcode() {
        String barcode = "01023";
        Stock stock = Stock.builder()
                .stockFillingId("stockfill001")
                .barcode(barcode)
                .price(new Price(2000, "INR"))
                .productId("pro001")
                .sellerId("seller001")
                .build();
        when(inventoryRepository.save(barcode, stock)).thenReturn(stock);

        String savedStockBarcode = inventoryService.fillUp(stock);

        assertEquals(barcode, savedStockBarcode);
    }
}
