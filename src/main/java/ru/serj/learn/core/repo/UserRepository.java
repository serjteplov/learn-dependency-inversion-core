package ru.serj.learn.core.repo;

import ru.serj.learn.core.api.User1;

import java.util.UUID;

public interface UserRepository {
    User1 find(UUID id);
}
