package com.verint.ecommerce.controller;

import org.springframework.web.bind.annotation.*;

import com.verint.ecommerce.dto.Purchase;
import com.verint.ecommerce.dto.PurchaseResponse;
import com.verint.ecommerce.service.CheckoutService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {

        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

        return purchaseResponse;
    }

}









