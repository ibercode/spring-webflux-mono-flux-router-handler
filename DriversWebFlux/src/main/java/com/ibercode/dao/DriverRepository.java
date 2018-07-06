package com.ibercode.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.ibercode.model.Driver;

import reactor.core.publisher.Mono;

public interface DriverRepository extends ReactiveCrudRepository<Driver, String>{

	public Mono<Driver> findByCar(int car);
}
