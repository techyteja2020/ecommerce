package com.ecommerce.seller.controller;

import com.ecommerce.core.seller.ProductStockDescriptor;
import com.ecommerce.seller.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WareHouseController {

    @Autowired
    private WareHouseService wareHouseService;

    @PostMapping("/sellers/{sellerId}/products/{productId}/stocks")
    public ResponseEntity fillStock(@PathVariable("productId") String productId,
                                    @RequestBody ProductStockDescriptor productStockDescriptor,
                                    @PathVariable("sellerId") String sellerId) {
        return new ResponseEntity(wareHouseService.fillStock(productId, productStockDescriptor, sellerId), HttpStatus.CREATED);
    }

}
