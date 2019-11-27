FROM openjdk:8
MAINTAINER RoomBookingService
VOLUME /tmp
ARG JAR_FILE=target/RoomBookingService.jar
ADD ${JAR_FILE} RoomBookingService.jar
ENTRYPOINT ["java","-jar","/RoomBookingService.jar"]