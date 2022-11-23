package com.example.exchangeratechallenge.controllers;

import com.example.exchangeratechallenge.dtos.UserAuthDto;
import com.example.exchangeratechallenge.models.UserAuth;
import com.example.exchangeratechallenge.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    Flux<UserAuth> findAll() {
        return service.getAll();
    }

    @PostMapping()
    Mono<UserAuth> save(@RequestBody @Valid UserAuthDto user) {
        return service.save(modelMapper.map(user, UserAuth.class));
    }

}
