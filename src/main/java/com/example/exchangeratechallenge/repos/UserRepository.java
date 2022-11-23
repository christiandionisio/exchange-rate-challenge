package com.example.exchangeratechallenge.repos;

import com.example.exchangeratechallenge.models.UserAuth;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<UserAuth, Integer> {

    Mono<UserAuth> findByEmail(String email);

}
