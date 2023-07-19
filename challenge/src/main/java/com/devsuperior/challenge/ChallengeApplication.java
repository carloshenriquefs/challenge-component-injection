package com.devsuperior.challenge;

import com.devsuperior.challenge.entities.Order;
import com.devsuperior.challenge.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class ChallengeApplication implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(ChallengeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        Integer code = sc.nextInt();
        double basic = sc.nextDouble();
        double discount = sc.nextDouble();

        Order order = new Order(code, basic, discount);
        System.out.println("Pedido codigo: " + order.getCode());
        System.out.println("Valor total: R$ " + String.format("%.2f", orderService.total(order)));
    }
}
