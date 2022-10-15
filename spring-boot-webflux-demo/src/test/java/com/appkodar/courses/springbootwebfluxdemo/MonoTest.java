package com.appkodar.courses.springbootwebfluxdemo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Mono;

/**
 * created by Satheesh Raju on 15-10-2022
 */

@ExtendWith(MockitoExtension.class)
public class MonoTest
{


    @Test
    void mono_test() {
        Mono<String> mono=Mono.just("test").log();
        mono.subscribe(System.out::println);
    }
    @Test
    void mono_error_test() {
        Mono<?> mono=Mono.just("test")
                .then(Mono.error(new RuntimeException("Exception occured")))
                .log();
        mono.subscribe(System.out::println,e-> System.out.println(e.getMessage()));
    }
    @Test
    void mono_custom_subscriber_test() {
        Mono<String> mono=Mono.just("test");
        mono.subscribe(new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                subscription.request(5);
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Completed");
            }
        });
    }
    @Test
    void mono_custom_subscriber_error_test() {
        Mono<String> mono=Mono.just("test")
                .then(Mono.error(new RuntimeException("Exception occured")));
        mono.subscribe(new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                subscription.request(5);
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Completed");
            }
        });
    }

}
