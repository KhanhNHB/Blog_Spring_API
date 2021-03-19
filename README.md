# Blog_Spring_API
This is blog post RESTful API application. Using Spring Boot Framework. 
  + We have used PostgreSQL as the relational database and JDBC to interact with that. 
  + We have used Flyway as migration data from file sql to database.
  + We have used JSON Web token (JWT) TO add authentication. Using JWT, we can protect certain endpoints and ensure that user must be logged-in to access thoes;

Setup and Installation:
Clone the repository from Github:
git clone https://github.com/KhanhNHB/Blog_Spring_API:
cd blog

You need the following installed for running the example:
You can use either of the below 2 options:

  + one way is to download from here and install locally on the machine
another option is by running a postgres docker container:
docker container run --name postgresdb -e POSTGRES_PASSWORD=admin -d -p 5432:5432 postgres
Create database objects
  + if using docker (else skip this step), first copy this file to the running container using below command and then exec into the running container:
docker-compose up
docker container cp expensetracker_db.sql postgresdb:/
docker container exec -it postgresdb bash
run the script using psql client:
psql -U postgres --file expensetracker_db.sql
(Optional) Update database configurations in application.properties


If your database is hosted at some cloud platform or if you have modified the SQL script file with some different username and password, update the src/main/resources/application.properties file accordingly:

spring.datasource.url=jdbc:postgresql://localhost:5432/blog
spring.datasource.username=postgres
spring.datasource.password=123ASDqwe
Run the spring boot application

./mvnw spring-boot:run
this runs at port 5050 and hence all enpoints can be accessed starting from http://localhost:5050

![alt text](https://spring.io/images/spring-logo-9146a4d3298760c2e7e49595184e1975.svg)
