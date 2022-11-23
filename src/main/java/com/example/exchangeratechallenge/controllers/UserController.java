package com.example.exchangeratechallenge.controllers;

import com.example.exchangeratechallenge.dtos.UserAuthDto;
import com.example.exchangeratechallenge.models.UserAuth;
import com.example.exchangeratechallenge.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    ModelMapper modelMapper = new ModelMapper();

    @GetMapping
    Mono<ResponseEntity<Flux<UserAuth>>> findAll() {
        return Mono.just(ResponseEntity.ok(service.getAll()));
    }

    @PostMapping()
    Mono<ResponseEntity<UserAuth>> save(@RequestBody @Valid UserAuthDto user) {
        return service.save(modelMapper.map(user, UserAuth.class))
                .flatMap(resp -> Mono.just(ResponseEntity.status(HttpStatus.CREATED).body(resp)))
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

}
