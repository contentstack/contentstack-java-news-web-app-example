# Contentstack Web Application using Java SDK and Spring Boot

[![Contentstack|Java](https://pbs.twimg.com/profile_images/1266413833091903489/tGyTwTYc_200x200.jpg)](https://www.contentstack.com)

![Java CI with Maven](https://github.com/contentstack/contentstack-java-news-web-app-example/workflows/Java%20CI%20with%20Maven/badge.svg)

A Sample Web Application created using Spring Boot and Contentstack Java SDK.

This guide provides step-by-step instructions to get up and running quickly with Spring Boot and create a web application with it using Contentstack Java SDK.

If you want to create your own Spring Boot-based project, visit [Spring Initializr](https://start.spring.io/), fill in your project details, select your options, and download the project as a zip file.

## Step 1: Set up the Essentials


 - Any text editor or IDE

 - JDK 1.8 or later

 - Gradle 4+ or Maven 3.2+

 - Contentstack account

## Step 2: How to Use this Project

- To start from scratch, visit [Spring Initializr](https://start.spring.io/).

- Or if you want to skip the basic setup and use our sample, perform the following steps:

- Download and unzip the source repository for this guide, or clone it using Git: git clone https://github.com/contentstack/contentstack-java-news-web-app-example.git

- cd contentstack-java-news-web-app-example

- Run the Application.


## Step 3: Add Contentstack Dependency

add dependency:

For Maven

```
<dependencies>
    <dependency>
       <groupId>com.contentstack.sdk</groupId>
       <artifactId>java</artifactId>
       <version><latest></version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
```

For Gradle

```
implementation 'com.contentstack.sdk:java:1.5.3'
implementation 'org.springframework.boot:spring-boot-starter-thymeleaf:2.3.3.RELEASE'
implementation 'org.springframework.boot:spring-boot-starter-web:2.3.3.RELEASE'
```


## Step 4: Run the Application

To run the application, run the following command in a terminal window (in the complete) directory

```
./gradlew bootRun
```

If you have used Maven for this project then run the following command in a terminal window (in the complete) directory:

```
./mvnw spring-boot:run
```


Now run the service with curl (in a separate terminal window), by running the following command (shown with its output):

```
$ curl localhost:8080
```

Or Open your favorite browser and try calling: http://localhost:8080


[Read Documentation](www.contentstack.com/docs/developers/sample-apps/build-a-web-application-using-contentstack-java-sdk-and-spring-boot/)

We have hosted our webapp on Herokuapp:

#### https://contentstack-news.herokuapp.com


![Screenshot](https://github.com/contentstack/contentstack-java-news-web-app-example/blob/master/screenshot.png?raw=true)



