package com.ibercode.service;

import org.springframework.stereotype.Service;

import com.ibercode.api.DriverRepository;
import com.ibercode.model.Driver;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DriverService {

    private DriverRepository repository;

    public DriverService(DriverRepository repository) {
	this.repository = repository;
    }
    
    public Mono<Driver> findDriverByCar(int car){
	return repository.findByCar(car);
    }

    public Flux<Driver> findAll() {
	return repository.findAll();
    }

    public Mono<Driver> save(Driver driver) {
	return repository.save(driver);
    }

    public Mono<Void> delete(Driver driver) {
	return repository.delete(driver);
    }
}
