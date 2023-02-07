package com.verint.ecommerce.dto;

import lombok.Data;

import java.util.Set;

import com.verint.ecommerce.entity.Address;
import com.verint.ecommerce.entity.Customer;
import com.verint.ecommerce.entity.Order;
import com.verint.ecommerce.entity.OrderItem;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
