package com.verint.ecommerce.service;

import com.verint.ecommerce.dto.Purchase;
import com.verint.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
