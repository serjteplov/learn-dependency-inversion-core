package ru.serj.learn.core.repo;

import ru.serj.learn.core.model.Product;

import java.util.UUID;

public interface ProductRepository {
    Product find(UUID id);

}
