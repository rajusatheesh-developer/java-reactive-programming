package com.appkodar.courses.springwebblockingapidemo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Instant;
import java.util.List;

/**
 * created by Satheesh Raju on 15-10-2022
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/customers")
public class CustomerController {


    private final CustomerService customerService;


    @GetMapping(value = "/blocking",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public List<Customer> getAll() {
        return customerService.loadAllCustomers();
    }

    @GetMapping(value = "/non-blocking",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllAsStream() {
        return customerService.loadAllCustomersAsStream();
    }


}
