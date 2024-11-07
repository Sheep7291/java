Project for managing daily exercises and create training plans.
Methods in project create, modify, delete, and read training plan with exercises inside,
add exercise to already existed training plan, move training plan for int days.

How to run project? Download project, add as maven and download all dependency, open command line in root file, type docker compose up in command line, type mvn spring-boot:run, next  when you run type in browser http://localhost:8080/swagger-ui/index.html#/training-plan-controller/getTrainingPlan for oper swagger. You will see login page, default username is Sheep and password 123

Plan for project: 
- Put whole project to docker and create Postgres database on docker container. 
- Create user structure with user types relation to specific endpoints
- create front-end

Used technologies:
Hibernate, Spring boot, Liquibase

Project created by: 
Dominik Jankowski
