package com.devsuperior.challenge.service;

import static com.devsuperior.challenge.constants.Constants.HUNDRED;
import static com.devsuperior.challenge.constants.Constants.TWELVE;
import static com.devsuperior.challenge.constants.Constants.TWENTY;
import static com.devsuperior.challenge.constants.Constants.TWO_HUNDRED;

import com.devsuperior.challenge.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total(Order order) {
        if (order.getBasic() < HUNDRED) {
            return shippingService.shipment(order) + TWENTY;
        } else if (order.getBasic() <= TWO_HUNDRED) {
            return shippingService.shipment(order) + TWELVE;
        } else {
            return shippingService.shipment(order);
        }
    }
}
