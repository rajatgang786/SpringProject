package com.musejam.component.taxation;

import com.musejam.dao.taxation.GSTDAO;
import com.musejam.model.pricing.Cart;
import com.musejam.model.pricing.OrderItem;
import com.musejam.table.pricing.AddOn;
import com.musejam.table.pricing.Product;
import com.musejam.table.taxation.GST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TaxationFetchClass {
    @Autowired
    GSTDAO gstDao;

    private Set<String> getHsnFromOrderItem(OrderItem orderItem){
        Set<String> hsnList = new HashSet<>();
        Product product = orderItem.getProduct();
        hsnList.add(product.getItemDetails().getHsn());
        for (AddOn addOn:orderItem.getAddOns() ) {
            hsnList.add(addOn.getItemDetails().getHsn());
        }
        return hsnList;
    }

    private Set<String> getHsnFromOrderItems(List<OrderItem> orderItems){
        Set<String> hsnList = new HashSet<>();
        for (OrderItem orderItem:orderItems ) {
            hsnList.addAll(getHsnFromOrderItem(orderItem));
        }
        return hsnList;
    }
    private Map<String,GST> fetchforOrderItems(List<OrderItem> orderItems){

       Map<String,GST> resultMap = new HashMap<>();
        Set<String> hsnList =  getHsnFromOrderItems(orderItems);
        for (String hsn: hsnList) {
            GST gst = gstDao.findByHsn(hsn);
            resultMap.put(hsn,gst);
        }
        return resultMap;
    }

    //Retrieving data of GST(HSN)
    public Map<String,GST> fetch(Cart cart){

        return fetchforOrderItems(cart.getOrderItems());
    }
}
