package com.musejam.model.pricing;

import com.musejam.table.taxation.GST;
import com.musejam.table.pricing.AddOn;
import com.musejam.table.pricing.Product;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderItem {
    Product product;
    Double grossAmount = 0D;
    Double netAmount = 0D;
    int quantity = 0;
    List<AddOn> addOns = new ArrayList();
    GST gst = new GST();
}
