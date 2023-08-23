package ru.serj.learn.core.service;

import ru.serj.learn.core.model.CreateOrderContext;
import ru.serj.learn.core.model.Order;

import java.util.List;
import java.util.UUID;

public class OrderService {

    private final List<CreateOrderObserver> observerList;

    public OrderService(List<CreateOrderObserver> observerList) {
        this.observerList = observerList;
    }

    public void create(CreateOrderContext context) {
        observerList.forEach(a -> a.onStart(context));

        var user = context.getUser();
        var product = context.getProduct();

        if (user.getBalance() < product.getPrice()) {
            throw new RuntimeException("Недостаточно средств");
        }

        Order order = new Order(UUID.randomUUID(), user.getId(), product.getId());
        context.setOrder(order);

        observerList.forEach(a -> a.onEnd(context));
    }
}