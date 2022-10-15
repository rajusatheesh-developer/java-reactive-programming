package com.appkodar.courses.springbootwebfluxdemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;


/**
 * created by Satheesh Raju on 15-10-2022
 */

@ExtendWith(MockitoExtension.class)
public class FluxTest {


    @Test
    void flux_test() {
        Flux<String> flux = Flux.just("test").log();
        flux.subscribe(System.out::println);
    }


}
