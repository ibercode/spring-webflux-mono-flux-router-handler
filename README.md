# spring-webflux-mono-flux-router-handler
Reactive Programming with Spring using Flux and Mono, Router and Handler with MongoDB

CRUD REST API using the Spring 5 Reactive Programming and the MongoDB database.

Prerequisite : install and configure the MongoDB, the database name is reactive and the collection name is drivers.
This project was created using the Spring Initalizr with the following dependencies:

	ReactiveWeb
	MongoDB
	ReactiveMongoDB
	DevTools

_______________________
Driver Model/Entity:

@Document(collection = "drivers")
public class Driver {
	
	@Id
	private String id;
	private String name;
	private int car;
	private String team;
  
  //constructors 
  //getters & setters
  ...

________________________

Database Initialization:
Uncomment all the line in the DatabaseInitialization Class in order to POST the first entity

	@Component
	public class DatabaseInitialization implements CommandLineRunner{

		@Autowired
		private DriverRepository repository;

		@Override
		public void run(String... args) throws Exception {
			Driver driver = new Driver("Fernando Alonso", 14, "McLaren");

			repository.findAll()
			.then(Mono.just(driver))
			.flatMap(repository::save)
			.subscribe();
		}
	}

_______________________

configure the database and the logging into the application.properties file:

spring.data.mongodb.uri=mongodb://localhost:27017/reactive

logging.level.org.springframework.data=DEBUG
logging.level.=error

CRUD REQUESTs and URLs:

#GET all drivers

	GET localhost:8080/rest/drivers   

#GET one driver by car number

	GET localhost:8080/rest/drivers/55
	
#POST save new driver

	POST localhost:8080/rest/drivers
	
#PUT  update existing driver

	PUT localhost:8080/rest/drivers/
	
#DELETE delete existing driver by car number

	DELETE localhost:8080/rest/drivers/77
	

______________________
