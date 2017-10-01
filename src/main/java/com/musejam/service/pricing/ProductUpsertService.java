package com.musejam.service.pricing;

import com.musejam.dao.pricing.ProductDAO;
import com.musejam.table.pricing.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service


public class ProductUpsertService {


    @Autowired
    ProductDAO productDAO;

    public void storeProduct(Product product){
        productDAO.save(product);
    }

    public void deleteItem(Product product)
    {
        productDAO.delete(product);
    }
}
