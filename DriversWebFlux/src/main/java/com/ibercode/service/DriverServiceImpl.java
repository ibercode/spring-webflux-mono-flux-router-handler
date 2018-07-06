package com.ibercode.service;

import org.springframework.stereotype.Service;

import com.ibercode.api.DriverService;
import com.ibercode.dao.DriverRepository;
import com.ibercode.model.Driver;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DriverServiceImpl implements DriverService {

    private DriverRepository repository;

    public DriverServiceImpl(DriverRepository repository) {
	this.repository = repository;
    }
    
    @Override
    public Mono<Driver> findDriverByCar(int car){
	return repository.findByCar(car);
    }

    @Override
    public Flux<Driver> findAll() {
	return repository.findAll();
    }

    @Override
    public Mono<Driver> save(Driver driver) {
	return repository.save(driver);
    }

    @Override
    public Mono<Void> delete(Driver driver) {
	return repository.delete(driver);
    }
}
