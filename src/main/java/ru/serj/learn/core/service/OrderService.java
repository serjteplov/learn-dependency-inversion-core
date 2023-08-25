package ru.serj.learn.core.service;

import ru.serj.learn.core.api.CreateOrderRequest;
import ru.serj.learn.core.api.Order;
import ru.serj.learn.core.repo.OrderRepository;
import ru.serj.learn.core.repo.ProductRepository;
import ru.serj.learn.core.repo.UserRepository;
import java.util.UUID;

public class OrderService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final CreateOrderObserver observer;

    public OrderService(UserRepository userRepository,
                        ProductRepository productRepository,
                        OrderRepository orderRepository,
                        CreateOrderObserver observer) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.observer = observer;
    }

    public void create(CreateOrderRequest request) {
        try {
            observer.onStart();

            var user = userRepository.find(request.getUserId());
            var product = productRepository.find(request.getProductId());

            if (user.getBalance() < product.getPrice()) {
                throw new RuntimeException("Недостаточно средств");
            }

            Order order = new Order(UUID.randomUUID(), user.getId(), product.getId());
            orderRepository.create(order);

            observer.onEnd();
        } finally {
            observer.onFinally();
        }
    }
}