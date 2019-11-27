# RoomBookingServices
Project Starter - RoomBookingServiceApplication.java class
ResponseEntity exception handling (controller) - RestResponseEntityExceptionHandler.java

Swagger api handler -
SwaggerConfig.java can be connected on http://localhost:8080/swagger-ui.html when application is up and running. 
All api are available to test.

# API endpoints -

### /booking
This endpoint is used to create a booking.
#### POST - localhost:8080/booking 

Json request
	{
		"roomId":2,
		"checkInDate":"2019-04-29",
		"checkOutDate": "2019-04-30"
	}

Json response
	{
		"dbId": 1,
		"bookingSuccessful":"true"
	}
	
### /rooms 
This endpoint is used to get available rooms and all bookings of rooms.
#### GET - localhost:8080/rooms 

Json response
	{
		"roomId":2,
		"roomType":"single",
		"bookingDates": ["2019-04-30", "2019-04-29"]
	}


### /bookings
This endpoint is used to get all bookings.
#### GET - localhost:8080/bookings 

Json response
	{
		"bookingId":2,
		"roomId":"1",
		"roomType":"single",
		"checkInDate":"2019-04-29",
		"checkOutDate": "2019-04-30"
	}


# H2 DATABASE - 
Currently I have used H2 in-memory databse to ease the development (configuration in h2_db_application.properties), but additionaly postgreSQL db configuration is added in file postgresql_db_application.properties. As Spring data jpa is used and hence it works swiftly with postgreSQL db as well.

for H2 db users - 
Database can be connected on http://localhost:8080/h2-console
JDBC URL - jdbc:h2:mem:roombookingservicedb
User name- sa
password No password required.
DB configuration is available in properties file inside src/main/resources folder structure.

### Entities 
Room
RoomType
Booking

### data.sql contains sql queries to execute before testing. Sql queries provide Room and RoomType for testing purpose, so that we can create a Booking.


# Unit testing

in folder structure src/test/java
For unit testing mockito is used to provide mock. Unit testing is performed layer by layer (bottom to up) which means, once repository layer's testing is performed, mock repository is used in service to evaluate desired outcome.

# pom.xml
H2 DB dependency.
Springforx for swagger api.
Spring boot jpa, starter, dev tools etc.

# Project build -
a) mvn clean package. It will create RoomBookingServices.jar in target folder.

b) java -jar RoomBookingServices.jar Execute it using command prompt. 
## OR 
It is a SpringBoot project and can be simply executed as a java project from RoomBookingServiceApplication.java class.

# Docker
a) Create a Dockerfile named as Dockerfile.txt
b) Build an image using command ==> docker build -t roombookingservice .
c) Run docker container ==> docker run -d -p 8080:8080 RoomBookingService 
d) List of built Docker images ==> docker ps -a 
e) To check container Logs==> docker logs <container_name or container_id>
