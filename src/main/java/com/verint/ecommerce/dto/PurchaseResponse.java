package com.verint.ecommerce.dto;



import lombok.Data;

@Data
public class PurchaseResponse {

    private final String orderTrackingNumber;
    private final String customer;
}
