package com.appkodar.courses.springwebfluxrouterfunctiondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

/**
 * created by Satheesh Raju on 15-10-2022
 */
@Configuration
public class UserRouterConfig {


    @Autowired
    private UserHandler userHandler;

    @Bean
    public RouterFunction<ServerResponse> userRouterFunction() {
        return RouterFunctions.route()
                .GET("/route/users", userHandler::loadAllUsers)
                .build();
    }

}
