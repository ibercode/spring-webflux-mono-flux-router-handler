package com.ibercode.api;

import com.ibercode.model.Driver;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DriverService {

    Mono<Driver> findDriverByCar(int car);

    Flux<Driver> findAll();

    Mono<Driver> save(Driver driver);

    Mono<Void> delete(Driver driver);

}