package ru.serj.learn.core.repo;

import ru.serj.learn.core.api.Product;

import java.util.UUID;

public interface ProductRepository {
    Product find(UUID id);
}
