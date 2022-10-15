package com.appkodar.courses.springwebfluxrouterfunctiondemo;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * created by Satheesh Raju on 15-10-2022
 */
@Service
public class UserHandler {


    public Mono<ServerResponse> loadAllUsers(ServerRequest serverRequest) {
        Flux<User> flux= Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(System.out::println)
                .map(User::new);

        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(flux,User.class);
    }

}
