package ru.serj.learn.core.model;

import java.util.Map;

public class CreateOrderContext {
    private CreateOrderRequest request;
    private User1 user;
    private Product product;
    private Order order;

    private Map<String, Object> data;

    public CreateOrderContext(CreateOrderRequest request) {
        this.request = request;
    }

    public CreateOrderRequest getRequest() {
        return request;
    }

    public void setRequest(CreateOrderRequest request) {
        this.request = request;
    }

    public User1 getUser() {
        return user;
    }

    public void setUser(User1 user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}