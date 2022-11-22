package com.example.exchangeratechallenge.repos;

import com.example.exchangeratechallenge.models.UserAuth;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<UserAuth, Integer> {
}
