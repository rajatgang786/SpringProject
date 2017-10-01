package com.musejam.component.pricing;
//Bring Data from DB

import com.musejam.dao.pricing.AddOnsDAO;
import com.musejam.dao.pricing.ProductDAO;
import com.musejam.model.pricing.Cart;
import com.musejam.model.pricing.OrderItem;
import com.musejam.table.pricing.AddOn;
import com.musejam.table.pricing.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductPopulatorComponent {
    
    //ToDo define dao data from db
    @Autowired
    AddOnsDAO addOnsDAO;
    
    @Autowired
    ProductDAO productDAO;


    private Product populateProduct(Product product){
        return productDAO.findOne(product.getId());
    }

    //
    private AddOn populateAddon(AddOn addOn){
        return addOnsDAO.findOne(addOn.getId());
    }

    //Receiving the data from populate()
    //and sending the data to populateProduct and populateAddOn and receiving the data
    // returning data to populate
    private OrderItem populateOrderItem(OrderItem orderItem){
        OrderItem orderItemDetails = new OrderItem();

        Product product = orderItem.getProduct();
        Product productDetails = populateProduct(product);

        orderItemDetails.setProduct(productDetails);

        List<AddOn> addOns = orderItem.getAddOns();
        for (AddOn addOn :addOns) {
           AddOn addOnDetails =  populateAddon(addOn);
            orderItemDetails.getAddOns().add(addOnDetails);

        }
        return  orderItemDetails;
    }

    //Creating a List of Order Items
    private List<OrderItem> populateOrderItems(List<OrderItem> orderItems){
        List<OrderItem> populatedOrderItems = new ArrayList<>();
        for (OrderItem orderItem: orderItems) {
            OrderItem orderItemDetails =populateOrderItem(orderItem);
            populatedOrderItems.add(orderItemDetails);
        }
        return populatedOrderItems;
    }

    // List of all the items in the cart (Product and AddOns
    //By using loop we are sending single single
    //Returning data to cart
    public void populate(Cart cart){
        List<OrderItem> orderItems = cart.getOrderItems();

        List<OrderItem> populatedOrderItems = populateOrderItems(orderItems);
        cart.setOrderItems(populatedOrderItems);
    }
}
