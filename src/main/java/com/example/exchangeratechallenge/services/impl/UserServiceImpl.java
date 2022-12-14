package com.example.exchangeratechallenge.services.impl;

import com.example.exchangeratechallenge.models.UserAuth;
import com.example.exchangeratechallenge.repo.UserRepository;
import com.example.exchangeratechallenge.security.User;
import com.example.exchangeratechallenge.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public Mono<UserAuth> save(UserAuth user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return repository.save(user);
    }

    @Override
    public Flux<UserAuth> getAll() {
        return repository.findAll();
    }

    @Override
    public Mono<User> findByEmail(String email) {
        Mono<UserAuth> monoUsuario = repository.findByEmail(email);

        return monoUsuario
                .flatMap(u ->
                        Mono.just(new User(u.getEmail(), u.getPassword(), true, List.of(u.getRole()))));

    }
}
