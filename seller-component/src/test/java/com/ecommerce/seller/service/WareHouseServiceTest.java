package com.ecommerce.seller.service;

import com.ecommerce.core.common.Price;
import com.ecommerce.core.seller.ProductStockDescriptor;
import com.ecommerce.inventory.service.InventoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WareHouseServiceTest {
    @Mock
    private InventoryService inventoryService;

    @InjectMocks
    private WareHouseService wareHouseService;

    @Test
    public void testFillStock() {
        String productId = "pro001";
        String sellerId = "seller001";
        List<String> barcodeList = new ArrayList();
        String barcode1 = "tv123001";
        String barcode2 = "tv123002";
        barcodeList.add(barcode1);
        barcodeList.add(barcode2);
        Price price = new Price(24000.00, "INR");
        String stockId = "stockId";
        ProductStockDescriptor productStockDescriptor = ProductStockDescriptor.builder()
                .id(stockId)
                .quantity(4)
                .barcodeList(barcodeList)
                .price(price).build();

        when(inventoryService.fillUp(any())).thenReturn(stockId);

        String resultProductId = wareHouseService.fillStock(productId, productStockDescriptor, sellerId);

        assertEquals(stockId, resultProductId);
    }
}
