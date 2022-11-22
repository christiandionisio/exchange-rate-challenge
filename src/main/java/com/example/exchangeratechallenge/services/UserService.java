package com.example.exchangeratechallenge.services;

import com.example.exchangeratechallenge.models.UserAuth;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<UserAuth> save(UserAuth user);
    Flux<UserAuth> getAll();

}
