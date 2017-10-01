package com.musejam.service.pricing;

import com.musejam.component.pricing.PricingCalculationComponent;
import com.musejam.component.pricing.ProductPopulatorComponent;
import com.musejam.component.pricing.PromotionFlowExecutorComponent;
import com.musejam.model.pricing.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PricingFlowExecutorService {
    @Autowired
    PricingCalculationComponent pricingCalculationComponent;


    @Autowired
    ProductPopulatorComponent productPopulatorComponent;

    @Autowired
    PromotionFlowExecutorComponent promotionFlowExecutorComponent;


    public Cart executeCart(Cart cart){

        productPopulatorComponent.populate(cart);

        promotionFlowExecutorComponent.executeFlow(cart);

        pricingCalculationComponent.calculateCartValues(cart);

        return cart;
    }
}
