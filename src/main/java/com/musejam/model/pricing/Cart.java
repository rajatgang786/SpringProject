package com.musejam.model.pricing;

import com.musejam.model.taxation.GST;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {
    String userID;
    List<OrderItem> orderItems = new ArrayList<>();
    Double netAmount = 0D;
    Double grossAmount = 0D;
    GST gst = new GST();

}
