package com.example.exchangeratechallenge.repo;

import com.example.exchangeratechallenge.models.UserAuth;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<UserAuth, Integer> {

    Mono<UserAuth> findByEmail(String email);

}
