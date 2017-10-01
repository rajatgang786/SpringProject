package com.musejam.component.pricing;

import com.musejam.model.pricing.Cart;
import com.musejam.table.taxation.GST;
import com.musejam.model.pricing.OrderItem;
import com.musejam.table.pricing.AddOn;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class PricingCalculationComponent {

    //Calculating GrossAmountOrderItem
    private void calculateGrossAmountOrderItem(OrderItem orderItem){
        List<AddOn> addOns = orderItem.getAddOns();
        Double grossAmount = 0D;
        grossAmount += orderItem.getProduct().getItemDetails().getSellingPrice();
        for (AddOn addOn :addOns) {
            grossAmount += addOn.getItemDetails().getSellingPrice();
        }
        orderItem.setGrossAmount(grossAmount);
    }

    //Calculating NetAmountOrderItem
    private void calculateNetAmountOrderItem(OrderItem orderItem){
        Double netAmount = orderItem.getGrossAmount();
        netAmount += orderItem.getGst().getTotal();
        orderItem.setNetAmount(netAmount);
    }

    //Calculating TotalGSTOrderItem
    private void calculateTotalGSTOrderItem(OrderItem orderItem){
        GST gst = orderItem.getGst();
        Double totalGst = 0D;
        totalGst += gst.getCGST()+gst.getIGST()+gst.getSGST()+gst.getUTGST();
        gst.setTotal(totalGst);
    }

    //Methods are generated to calculate GrossAmountOrderItem TotalGstOrderItem and NetAmountOrderItem
    //orderItem is receiving product and AddOn details
    private void calculateOrderItem(OrderItem orderItem){
        calculateGrossAmountOrderItem(orderItem);
        calculateTotalGSTOrderItem(orderItem);
        calculateNetAmountOrderItem(orderItem);

    }

    //Receiving complete orderItemList
    //Sending one product and one AddOn to calculateOrderItem to be processed
    //Receiving Processed data
    private void calculateOrderItems(List<OrderItem> orderItems){
        for (OrderItem orderItem: orderItems) {
           calculateOrderItem(orderItem);
        }
    }

    //Calculating NetAmount and GST
    private void calculateNetAmount(Cart cart){
        Double netAmount = 0D;
        Double grossAmount = 0D;
        Double CGST =0D;
        Double SGST = 0D;
        Double IGST = 0D;
        Double UTGST = 0D;
        Double totalGST = 0D;
        //Double = 0D;

        for (OrderItem orderItems:cart.getOrderItems()) {
            grossAmount += orderItems.getGrossAmount();
            netAmount += orderItems.getNetAmount();
            GST gst = orderItems.getGst();
            CGST =  gst.getCGST();
            SGST = gst.getSGST();
            IGST = gst.getIGST();
            UTGST = gst.getUTGST();
            totalGST = gst.getTotal();

        }

        cart.getGst().setCGST(CGST);
        cart.getGst().setIGST(IGST);
        cart.getGst().setSGST(SGST);
        cart.getGst().setTotal(totalGST);
        cart.getGst().setUTGST(UTGST);
        cart.setNetAmount(netAmount);
        cart.setGrossAmount(grossAmount);
    }

    //Calculating cartValues
    public void calculateCartValues(Cart cart){
        List<OrderItem> orderItems = cart.getOrderItems();
        calculateOrderItems(orderItems);
        calculateNetAmount(cart);
    }
}
