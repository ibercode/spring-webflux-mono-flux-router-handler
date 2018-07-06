package com.ibercode.handlers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.ibercode.api.DriverService;
import com.ibercode.model.Driver;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class DriverHandler {

    private DriverService service;

    public DriverHandler(DriverService service) {
	this.service = service;
    }

    // GET - all
    public Mono<ServerResponse> findAllDrivers(ServerRequest request) {

	Flux<Driver> drivers = service.findAll();
	
	return ServerResponse
		.ok()
		.contentType(MediaType.APPLICATION_JSON)
		.body(drivers, Driver.class);
    }

    // GET - get one driver by car number
    public Mono<ServerResponse> findDriverByCarNumber(ServerRequest request) {

	
	Mono<Driver> driver = service
		.findDriverByCar(Integer.parseInt(request.pathVariable("car")));
	Mono<ServerResponse> notFound = ServerResponse.notFound().build();
	
	return driver
		.flatMap(d -> ServerResponse
				.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(driver, Driver.class))
		.switchIfEmpty(notFound);
    }

    // POST - save new driver
    public Mono<ServerResponse> saveDriver(ServerRequest request) {

	Mono<Driver> driver = request.body(BodyExtractors.toMono(Driver.class)).flatMap(d -> service.save(d));

	return ServerResponse
		.ok()
		.contentType(MediaType.APPLICATION_JSON)
		.body(driver, Driver.class);

    }

    // PUT - update driver
    public Mono<ServerResponse> updateDriver(ServerRequest request) {

	Mono<Driver> driver = service.findDriverByCar(Integer.parseInt(request.pathVariable("car")))
		.flatMap(d -> {
                	    Driver din = request.body(BodyExtractors.toMono(Driver.class)).block();
                	    d.setCar(din.getCar());
                	    d.setName(din.getName());
                	    d.setTeam(din.getTeam());
                	    return service.save(d);
			});
	return ServerResponse.ok()
		.contentType(MediaType.APPLICATION_JSON)
		.body(driver, Driver.class);

    }

    // DELETE - delete driver by car number
    public Mono<ServerResponse> deleteDriver(ServerRequest request) {

	service
		.findDriverByCar(Integer.parseInt(request.pathVariable("car")))
		.flatMap(d -> service.delete(d))
		.subscribe();

	return ServerResponse.ok().build();
    }
}
