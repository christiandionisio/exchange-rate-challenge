package com.example.exchangeratechallenge.services.impl;

import com.example.exchangeratechallenge.models.UserAuth;
import com.example.exchangeratechallenge.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class UserServiceImplTest {

    @MockBean
    private UserRepository repo;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    void getAll() {
        Mockito.when(repo.findAll())
                .thenReturn(Flux.fromIterable(getUsersMock()));

        StepVerifier.create(userServiceImpl.getAll())
                .expectNextCount(2)
                .verifyComplete();
    }

    @Test
    void save() {
        Mockito.when(repo.save(Mockito.any()))
                .thenReturn(Mono.just(getOneUserMock()));

        StepVerifier.create(userServiceImpl.save(getOneUserMock()))
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void findByEmail() {
        Mockito.when(repo.findByEmail(Mockito.any()))
                .thenReturn(Mono.just(getOneUserMock()));

        StepVerifier.create(userServiceImpl.findByEmail(Mockito.any()))
                .expectNextCount(1)
                .verifyComplete();
    }

    List<UserAuth> getUsersMock() {
        List<UserAuth> usersList = new ArrayList<>();
        UserAuth user1 = new UserAuth();
        user1.setEmail("test@test.com");
        user1.setPassword("abc");
        user1.setRole("USER");

        UserAuth user2 = new UserAuth();
        user2.setEmail("test2@test.com");
        user2.setPassword("abc");
        user2.setRole("USER");

        usersList.add(user1);
        usersList.add(user2);

        return usersList;
    }

    UserAuth getOneUserMock() {
        UserAuth user1 = new UserAuth();
        user1.setEmail("test@test.com");
        user1.setPassword("abc");
        user1.setRole("USER");

        return user1;
    }

}