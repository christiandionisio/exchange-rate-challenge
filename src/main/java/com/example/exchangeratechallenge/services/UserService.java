package com.example.exchangeratechallenge.services;

import com.example.exchangeratechallenge.models.UserAuth;
import com.example.exchangeratechallenge.security.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<UserAuth> save(UserAuth user);
    Flux<UserAuth> getAll();
    Mono<User> findByEmail(String email);

}
