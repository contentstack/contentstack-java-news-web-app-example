# Web-App Using Contentstack-java SDK and Spring-Boot

A Sample Example Code for contentstack-Java SDK using Spring-Boot,
This guide is meant to give you a quick taste of integration of Contentstack-Java SDK with Spring Boot web-app. If you want to create your own Spring Boot-based project, visit [Spring Initializr](https://start.spring.io/), fill in your project details, pick your options, and download a bundled up project as a zip file.


## Step: 1 You will build a simple news web application with Spring Boot and contentstack Java SDK.


- A favorite text editor or IDE

- JDK 1.8 or later

- Gradle 4+ or Maven 3.2+


## Step: 2 How to complete this guide

- To start from scratch, move on to Starting with [Spring Initializr](https://start.spring.io/).

- To skip the basics, do the following:

- Download and unzip the source repository for this guide, or clone it using Git: git clone https://github.com/contentstack/contentstack-java-news-web-app-example.git

- cd contentstack-java-news-web-app-example

- Run the Application.


## Step: 3 Add Contentstack Dependency

add dependency:

For Maven

```
<dependency>
   <groupId>com.contentstack.sdk</groupId>
   <artifactId>java</artifactId>
   <version>1.5.3</version>
</dependency>
```

For Gradle

```
implementation 'com.contentstack.sdk:java:1.5.3'
```


## Step: 4 For View Rendering

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

## Step: 5 Run the Application


To run the application, run the following command in a terminal window (in the complete) directory

```
./gradlew bootRun
```

If you use Maven, run the following command in a terminal window (in the complete) directory:

```
./mvnw spring-boot:run
```


Now run the service with curl (in a separate terminal window), by running the following command (shown with its output):

```
$ curl localhost:8080
Headlines from Spring Boot!
```

Or simply click on the below url hosted on herokuapp

[View Website](https://contentstack-news.herokuapp.com/)


![Screenshot](https://github.com/contentstack/contentstack-java-news-web-app-example/blob/master/snapshot.png?raw=true)


