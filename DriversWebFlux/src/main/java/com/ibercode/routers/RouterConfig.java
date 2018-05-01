package com.ibercode.routers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.ibercode.handlers.DriverHandler;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;

@Configuration
@EnableWebFlux
public class RouterConfig implements WebFluxConfigurer{

	@Bean
	public RouterFunction<ServerResponse> routes(DriverHandler handler){
		
		return RouterFunctions
				.route(GET("/rest/drivers"),
						handler::findAllDrivers)
				.andRoute(GET("/rest/drivers/{car}"),
						handler::findDriverByCarNumber)
				.andRoute(POST("/rest/drivers"),
						handler::saveDriver)
				.andRoute(PUT("/rest/drivers/{car}"), 
						handler::updateDriver)
				.andRoute(DELETE("/rest/drivers/{car}"),
						handler::deleteDriver);
	}
	
} 
 