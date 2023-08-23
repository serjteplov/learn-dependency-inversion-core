package ru.serj.learn.core.service;

import ru.serj.learn.core.model.CreateOrderContext;

public interface CreateOrderObserver {
    void onStart(CreateOrderContext context);

    void onEnd(CreateOrderContext context);
}
