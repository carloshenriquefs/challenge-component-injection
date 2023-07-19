package com.devsuperior.challenge.service;

import com.devsuperior.challenge.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(Order order) {
        return order.getBasic() - (order.getBasic() * (order.getDiscount() / 100));
    }
}
