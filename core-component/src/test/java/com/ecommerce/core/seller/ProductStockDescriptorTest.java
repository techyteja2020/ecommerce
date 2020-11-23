package com.ecommerce.core.seller;

import com.ecommerce.core.common.Price;
import com.ecommerce.core.inventory.Stock;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProductStockDescriptorTest {

    @Test
    public void givenProductStockDescriptorConvertsToStocksSuccessfully() {
        List<String> barcodeList = new ArrayList();
        String barcode1 = "tv123001";
        String barcode2 = "tv123002";
        barcodeList.add(barcode1);
        barcodeList.add(barcode2);
        //Price price = new Price(24000.00, "INR");
        Price price = new Price();
      /*  price.setAmount(24000);
        price.setCurrency("INR");*/
        String productId = "pr001";
        String sellerId = "seller001";
        ProductStockDescriptor productStockDescriptor = new ProductStockDescriptor("stockId",4, barcodeList, price);
        Stock stockItem1 = new Stock(productId, sellerId, barcode1, price, productStockDescriptor.getId());
        Stock stockItem2 = new Stock(productId, sellerId, barcode2, price, productStockDescriptor.getId());

        List<Stock> expectedStockList = new ArrayList<>();
        expectedStockList.add(stockItem1);
        expectedStockList.add(stockItem2);

        List<Stock> stockList = productStockDescriptor.convertToStockList(productId, sellerId);

        assertEquals(expectedStockList, stockList);
    }

}