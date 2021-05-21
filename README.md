# employeemanagement-rest
Spring Boot Application

Employee Management Application Using React and Spring Boot
	Spring Boot + React Full Stack app Architecture: -
Application Architecture: -

•	At the client side we have React application. We have different component involved in React application architecture. E.g Router, Component, Service. We configure Router along with its component and we inject service in a component.

•	So we write all the Http Rest client code inside service and we inject service in a component i.e. we call a service method from components.

•	In the middle we have Axios Http library which is used to make a Rest API call. React is not concern with Http so we have to use a 3rd party Http library (Axios library) to make the Http API call.

•	In the server side we have Spring Boot application.

•	The Spring Rest Controller will handle the Http call for example Get, Post, Put, Delete

•	The second component in the server side is Spring Data JPA used to develop DAO (Data Access Object) layer. This is used to reduce lots of boiler plate code to develop the DAO layer.

•	We are going to use MY SQL data base as the database layer.

Client side Tools and Technologies used: -
•	React Library
•	Modern JavaScript (ES6)
•	NodeJs and NPM
•	Visual Studio Code IDE (Integrated Development Environment)
•	Create React App CLI
•	Bootstrap 4.5 and Axios HTTP library
Server side Tools and Technologies used: -
•	Spring Boot 2+
•	Spring Data JPA (Hibernate)
•	Maven
•	JDK 11
•	Embedded Tomcat Server 8.5+
•	Spring Tool Suite IDE (STS)
•	Postman – REST Client Tester
•	MySQL Database

Let’s Start: -

•	Create a Spring Boot app from Spring starter project feature available at STS (Spring Tool Suite)

•	During creation of the project add these dependencies- 

    Spring Web – It will add the embedded Tomcat server and other important dependencies.
    Spring Data JPA- To avail the development of DAO layer
    MySQL Driver- To establish the connectivity with Database
    Spring Boot Dev Tools- It will help to add the changes automatically and we don’t need to restart the server manually each time.
