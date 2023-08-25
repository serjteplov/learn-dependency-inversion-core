package ru.serj.learn.core.service;

import ru.serj.learn.core.api.CreateOrderRequest;
import ru.serj.learn.core.api.Order;
import ru.serj.learn.core.repo.OrderRepository;
import ru.serj.learn.core.repo.ProductRepository;
import ru.serj.learn.core.repo.UserRepository;

import java.util.UUID;

public class OrderServiceImpl implements OrderService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderServiceImpl(UserRepository userRepository,
                            ProductRepository productRepository,
                            OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void create(CreateOrderRequest request) {
        var user = userRepository.find(request.getUserId());
        var product = productRepository.find(request.getProductId());

        if (user.getBalance() < product.getPrice()) {
            throw new RuntimeException("Недостаточно средств");
        }

        Order order = new Order(UUID.randomUUID(), user.getId(), product.getId());
        orderRepository.create(order);

    }
}