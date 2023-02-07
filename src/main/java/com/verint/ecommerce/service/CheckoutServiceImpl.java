package com.verint.ecommerce.service;

import org.springframework.stereotype.Service;

import com.verint.ecommerce.dao.CustomerRepository;
import com.verint.ecommerce.dto.Purchase;
import com.verint.ecommerce.dto.PurchaseResponse;
import com.verint.ecommerce.entity.Customer;
import com.verint.ecommerce.entity.Order;
import com.verint.ecommerce.entity.OrderItem;

import jakarta.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve the order info from dto
        Order order = purchase.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        // populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        // populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);

        // save to the database
        customerRepository.save(customer);

        // return a response
        return new PurchaseResponse(orderTrackingNumber,customer.getFirstName());
    }

    private String generateOrderTrackingNumber() {

       
        return UUID.randomUUID().toString();
    }
}









