package com.ibercode.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ibercode.api.DriverRepository;
import com.ibercode.model.Driver;

import reactor.core.publisher.Mono;

@Component
public class DatabaseInitialization implements CommandLineRunner {

    private DriverRepository repository;

    public DatabaseInitialization(DriverRepository repository) {
	this.repository = repository;
    }

    //
    @Override
    public void run(String... args) throws Exception {
//	 Driver driver = new Driver("Fernando Alonso", 14, "McLaren");
//
//	 repository.findAll()
//	 .then(Mono.just(driver))
//	 .flatMap(repository::save)
//	 .subscribe();
    }

}
