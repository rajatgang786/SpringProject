package com.musejam.component.taxation;

import com.musejam.model.pricing.Cart;
import com.musejam.model.pricing.OrderItem;
import com.musejam.table.pricing.AddOn;
import com.musejam.table.pricing.ItemDetails;
import com.musejam.table.pricing.Product;
import com.musejam.table.taxation.GST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TaxationCalculatorComponent {

    @Autowired
    TaxationFetchClass taxationFetchClass;
    Map<String,GST>hsnGstMap = new HashMap<>();

    public void calculateTax(Cart cart){
        hsnGstMap =taxationFetchClass.fetch(cart);
        calculateTaxForOrderItems(cart.getOrderItems());
    }

    //To check whether Tax is inclusive or not
    //Assumed it is inclusive
    public boolean isTaxInclusive(ItemDetails itemDetails){
        return true;
    }
    //Calculate InclusiveTax
    public void calculateInclusive(ItemDetails itemDetails){
        Double sp = 0D;
        String hsn = itemDetails.getHsn();
        GST gst = hsnGstMap.get(hsn);
        Double CGST = itemDetails.getSellingPrice() - itemDetails.getSellingPrice()   / (( gst.getCgstPercentage() / 100 ) +1 );
        Double IGST = itemDetails.getSellingPrice() - itemDetails.getSellingPrice()   / (( gst.getIgstPercentage() / 100 ) +1 );
        Double UTGST = itemDetails.getSellingPrice() - itemDetails.getSellingPrice()  / (( gst.getUtgstPercentage() / 100 ) +1 );
        Double SGST = itemDetails.getSellingPrice() - itemDetails.getSellingPrice()   / (( gst.getSgstPercentage()/ 100 ) +1 );

    }

    //Calculate ExclusiveTax
    public void calculateExclusive(ItemDetails itemDetails){}

    //List of OrderItems
    public void calculateTaxForOrderItems(List<OrderItem> orderItems){
        for (OrderItem orderItem:orderItems) {
            calculateTaxForOrderItem(orderItem);
        }
    }

    //Receiving single Product and Add-On
    public void calculateTaxForOrderItem(OrderItem orderItem){
        Product product = orderItem.getProduct();
        calculateTaxForItem(product.getItemDetails());
        List<AddOn> addOns = orderItem.getAddOns();
        for (AddOn addOn:addOns) {
            calculateTaxForItem(addOn.getItemDetails());
        }
    }

    //Calculating tax on each Product and Add-On
    public void calculateTaxForItem(ItemDetails itemDetails){
       if (isTaxInclusive(itemDetails))
            calculateInclusive(itemDetails);
       else
            calculateExclusive(itemDetails);
    }
}
