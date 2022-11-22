package com.example.exchangeratechallenge.services;

import com.example.exchangeratechallenge.models.UserAuth;
import com.example.exchangeratechallenge.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public Mono<UserAuth> save(UserAuth user) {
        return repository.save(user);
    }

    @Override
    public Flux<UserAuth> getAll() {
        return repository.findAll();
    }
}
