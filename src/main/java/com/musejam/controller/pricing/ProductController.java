package com.musejam.controller.pricing;

import com.musejam.table.pricing.Product;
import com.musejam.service.pricing.ProductUpsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/musejam/product")
public class ProductController {

    @Autowired
    ProductUpsertService productUpsertService;

    //Insert
    @RequestMapping("/upsert")
    @PostMapping
    public void saveProduct(@RequestBody  Product product) {
        productUpsertService.storeProduct(product);
    }

    //Delete
    @RequestMapping("/delete")
    @PostMapping
    public void delete(@RequestBody Product product){
        productUpsertService.deleteItem(product);
    }
}
