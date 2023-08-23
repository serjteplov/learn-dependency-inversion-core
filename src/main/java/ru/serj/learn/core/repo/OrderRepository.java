package ru.serj.learn.core.repo;

import ru.serj.learn.core.model.Order;

public interface OrderRepository {
    void create(Order order);

}
