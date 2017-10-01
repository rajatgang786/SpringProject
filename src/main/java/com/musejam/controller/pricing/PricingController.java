package com.musejam.controller.pricing;

import com.musejam.model.pricing.Cart;
import com.musejam.service.pricing.PricingFlowExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/musejam/pricing")
public class PricingController {

    @Autowired
    PricingFlowExecutorService pricingFlowExecutorService;
    @RequestMapping("/calculate_cart")
    @PostMapping
    public Cart calculateCart(@RequestBody Cart cart) {

        return pricingFlowExecutorService.executeCart(cart);

    }
}
