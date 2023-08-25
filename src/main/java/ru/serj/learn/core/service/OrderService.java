package ru.serj.learn.core.service;

import ru.serj.learn.core.api.CreateOrderRequest;

public interface OrderService {
    void create(CreateOrderRequest request);
}
