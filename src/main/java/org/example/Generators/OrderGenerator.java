package org.example.Generators;

import net.datafaker.Faker;
import org.example.Order.Order;
import org.example.Order.OrderStatus;

public class OrderGenerator {
    public static Faker faker = new Faker();

    public static Order generateNewOrder() {
        Order order = new Order();
        order.setId(faker.number().numberBetween(1, 10));
        order.setPetId(faker.number().numberBetween(1, 10));
        order.setQuantity(1);
        order.setShipDate("2023-10-29T14:13:03.967Z");
        order.setStatus(OrderStatus.PLACED);
        order.setComplete(order.isComplete());
        return order;
    }

}
