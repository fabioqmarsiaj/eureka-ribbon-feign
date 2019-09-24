# Microservices with eureka discovery, ribbon load balancing and Feign HTTP
**By Antonio Azambuja, Daniela Araújo and Fabio Marsiaj**

In this project the main goal is to practice concepts such as microservices, eureka discovery, feign http client requests
and load balancing with ribbon.

## Summary

  - [Introduction](#introduction)
  - [Requirements](#requirements)
  - [Installation](#installation)
  - [Eureka](#eureka)
  - [Feign](#feign)
  - [Ribbon](#ribbon)
  - [Video](#video)
  - [Authors](#authors)
  
  ## Introduction
  
   We have three microservices made with spring boot: app-service, playlist-service and song-service.
   
   The song-service has a database implemented with mongoDB, and contain an ID and TITLE.
   
   The playlist-service is also implemented with mongoDB and contain an ID and a LIST of songs ID's.
   
   Passing through parameter a playlist id to the app-service, one should get all details about the songs inside the playlist.
   
   Those are the application steps:
   - The app-service makes a GET request to the playlist-service with a playlist ID as parameter;
   - The playlist-service returns all songs inside that specific playlist;
   - Now, with all song ids, app-service makes a GET request to the song-service which returns all song details.
    
  ## Requirements
  
  - [Git](https://git-scm.com/)
  - [Java8](https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)
  - [Gradle](https://gradle.org/install/)
  - [Tomcat](http://tomcat.eu.apache.org/download-90.cgi?Preferred=ftp://apache.cs.utah.edu/apache.org/)
  - [Eureka](https://github.com/Netflix/eureka)
  
  ## Installation
  
 - Installing Git:
```
$apt-get install git
```
  
  - Clone the project from github:
```
$git clone https://github.com/fabioqmarsiaj/temafinal2-cloud
```

  - Java 8 installation:
```
$sudo apt update
```
  - Check if java is already installed or not:
```
$java -version
```
  - And then install by:
```
$sudo apt-get install openjdk-8-jdk
```
  - Gradle installation:
```
$sudo apt install gradle
```
 
  - Tomcat Installation:
      - You should have tomcat server running on your system, 
      so access the tomcat link and download and extract to any folder.

 - Clone Netflix Eureka repository:
```
$git clone https://github.com/Netflix/eureka.git
```

 - Access the ~/eureka folder and then run:
 ```
 $./gradlew eureka-server:build
 ```

 - It will generate the .war file at the eureka-server folder for our tomcat server. 
 The eureka.war file should be copied to the ~/tomcat/webapps folder of your system, previously installed.
 **PS: You could rename this .war file to eureka.war**
 
 - The last step is to run tomcat server:
```
$cd ~/tomcat/

$bin/catalina.sh run
```

  - Check the eureka homepage at https://localhost:8080/eureka
   
   ## Eureka
   By Netflix:
   
   _Eureka is a REST (Representational State Transfer) based service that is primarily used in the AWS cloud 
   for locating services for the purpose of load balancing and failover of middle-tier servers._
   
   All of our services are registered on eureka server, so we could manage and control the requests with load balancing.
   
   ## Feign
   By Netflix:
   
   _Feign is a Java to HTTP client binder inspired by Retrofit, JAXRS-2.0, and WebSocket. 
   Feign's first goal was reducing the complexity of binding Denominator uniformly to HTTP APIs regardless of RESTfulness._
   
   The communication between our services are made with Feign. It's more simple and clean.
   
   ## Ribbon
   By Netflix:
   
   _Ribbon is a client side IPC library that is battle-tested in cloud. It provides the following features
   Load balancing,
   Fault tolerance,
   Multiple protocol (HTTP, TCP, UDP) support in an asynchronous and reactive model,
   Caching and batching._
   
   Our requests to the song-service are controlled and load balanced, because we run two instances of the song-service.
   So Ribbon helps us to distribute our requests equally.
   
   ## Video
   [YouTube](https://youtu.be/Aka0QQX3MhU)
   
   ## Authors
   
**Antonio Marcos Silva de Azambuja** -  [GitHub](https://github.com/antonioazambuja)

<a href="https://github.com/fabioqmarsiaj">
    <img 
    alt="Imagem do Autor Antônio Azambuja" src="https://avatars3.githubusercontent.com/u/45765571?s=460&v=4" width="100">
</a>
   
   
 **Daniela Araújo** -  [GitHub](https://github.com/DaniiNyan)
 
<a href="https://github.com/fabioqmarsiaj">
     <img 
     alt="Imagem da Autora Daniela Araújo" src="https://avatars1.githubusercontent.com/u/42483133?s=460&v=4" width="100">
</a>
   
**Fabio Quinto Marsiaj** -  [GitHub](https://github.com/fabioqmarsiaj)

<a href="https://github.com/fabioqmarsiaj">
    <img 
    alt="Imagem do Autor Fabio Marsiaj" src="https://avatars0.githubusercontent.com/u/34289167?s=460&v=4" width="100">
</a>
  

  
