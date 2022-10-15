package com.appkodar.courses.springwebblockingapidemo;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * created by Satheesh Raju on 15-10-2022
 */
@Component
public class CustomerService {


    public static void sleepExecution(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> loadAllCustomers() {
        Instant start = Instant.now();
        List<Customer> list = IntStream.rangeClosed(1, 20)
                .peek(CustomerService::sleepExecution)
                .peek(System.out::println)
                .mapToObj(Customer::new)
                .collect(Collectors.toList());
        Instant end = Instant.now();
        System.out.println("Exe :" + Duration.between(start, end));
        return list;
    }

    public Flux<Customer> loadAllCustomersAsStream() {
        Instant start = Instant.now();
        Flux<Customer> flux = Flux.range(1, 20)
                .delayElements(Duration.ofMillis(1000))
                .doOnNext(System.out::println)
                .map(Customer::new);
        Instant end = Instant.now();
        System.out.println("Exe :" +
                Duration.between(start, end));
        return flux;
    }

}
