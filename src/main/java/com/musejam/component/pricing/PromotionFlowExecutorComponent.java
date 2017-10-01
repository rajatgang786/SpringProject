package com.musejam.component.pricing;

import com.musejam.model.pricing.Cart;
import com.musejam.model.pricing.OrderItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PromotionFlowExecutorComponent {


    private void setSellingPriceOrderItem(OrderItem orderItem) {

        Double sellingPrice = orderItem.getProduct().getItemDetails().getPrice();
        orderItem.getProduct().getItemDetails().setSellingPrice(sellingPrice);

    }

    private void setForOrderItems(List<OrderItem> orderItems) {

        for (OrderItem orderItem:
             orderItems) {

            setSellingPriceOrderItem(orderItem);

        }

    }



    public void executeFlow(Cart cart) {

        setForOrderItems(cart.getOrderItems());

    }


}
