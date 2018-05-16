# MD101 - Creating a Simple REST Microservice

## Introduction
In this module, we will introduce a fictional company we will be building microservices for called Ticket Monster. We will explore this company's needs, and use microservices to implement a solution. Throughout these courses, we will continue to build up our Ticket Monster microservice system. As a first step, we will build a single REST microservice from scratch.


---


## Skill Check
### Prerequisites 
* MD100 OR a beginners understanding of Java, Maven, and Spring Boot/Spring REST

### Outcome
* An understanding of the Ticket Monster project, and what we will be building over the next several courses
* The basics of Spring dependency injection
* How unit and integration tests fit into the development cycle, and how to write them
* How to model RESTful entities, and how to design/implement simple REST APIs


---


## Introducing Ticket Monster

### What is Ticket Monster?
TODO: What is Ticket Monster, and how does this fit into the training modules?

### What will we be building?
TODO: Architecture diagram, user management system

### Where do we begin?
TODO: Specifications of a user, lead in to step 1


## Getting hands on

Now that we know our what we need to build, let's start building it. We will begin with a single microservice called "user-middle", whose job is to handle creation, retrieval, updating, and deletion(CRUD, for short) of users. This microservice will store it's user data in memory for the time being, and by way of REST, we will be able to perform the aforementioned CRUD actions.

### How these modules work
These modules are broken down into steps, such as the step listed below. Each step has a start and end folder, with an isolated java project within it. The "start" state is where the instructions assume you are beginning from. The "end" state is an example of what you should have when the step is completed.

[Step 1 - Defining a User](step_1/README.md)


[Step 2 - Retrieving a User via RESTful HTTP](step_2/README.md)


[Step 3 - Controllers, Services, and Dependency Injection](step_3/README.md)


[Step 4 - Checking our work via Unit and Integration Tests](step_4/README.md)


[Step 5 - Creating New Users](step_5/README.md)


[Step 6 - Updating Existing Users](step_6/README.md)


[Step 7 - Deleting Users](step_7/README.md)
