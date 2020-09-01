# Contentstack webapp using Java SDK and Spring-Boot

A Sample Example Code for contentstack-Java SDK using Spring-Boot,
This guide is meant to give you a quick taste of integration of Contentstack-Java SDK with Spring Boot web-app. If you want to create your own Spring Boot-based project, visit [Spring Initializr](https://start.spring.io/), fill in your project details, pick your options, and download a bundled up project as a zip file.


### Step 1: Requirements

- A favorite text editor or IDE

- JDK 1.8 or later

- Gradle 4+ or Maven 3.2+


### Step 2: Getting started

- To start from scratch, move on to Starting with [Spring Initializr](https://start.spring.io/).

  Add below inside **dependencies**.
        
        // contentstack cda dependency
        <dependency>
            <groupId>com.contentstack.sdk</groupId>
            <artifactId>java</artifactId>
            <version>1.5.3</version>
        </dependency>
                    
        // for view rendering           
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
    		
        <dependency>
    	    <groupId>org.springframework.boot</groupId>
    	    <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
  
  open in your favorite editor or IDE


- To skip the basics, do the following:

- Download and unzip the source repository for this guide, or clone it using git

        git clone https://github.com/contentstack/contentstack-java-news-web-app-example.git

- cd contentstack-java-news-web-app-example


### Step 5: Run the Application


To run the application, run the following command in a terminal window (in the root) directory

```
./mvnw spring-boot:run
```

If you use gradle, run the following command in a terminal window (in the root) directory:

```
./gradlew bootRun
```


Now run the service with curl (in a separate terminal window), by running the following command (shown with its output):

```
$ http://localhost:8080
```

To see how it looks, click on the below url hosted on herokuapp

https://contentstack-news.herokuapp.com



#### Screenshot
![Screenshot](https://github.com/contentstack/contentstack-java-news-web-app-example/blob/master/screenshot.png?raw=true)


