package ru.serj.learn.core.repo;

import ru.serj.learn.core.api.Order;

public interface OrderRepository {
    void create(Order order);
}
