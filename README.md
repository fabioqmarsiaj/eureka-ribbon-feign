# Microservices with eureka discovery and ribbon load balancing
**By Antonio Azambuja, Daniela Araújo and Fabio Marsiaj**

In this project the main goal is to practice concepts such as microservices, eureka discovery, feign http client requests
and load balancing with ribbon.

## Summary

  - [Introduction](#introduction)
  - [Requirements](#requirements)
  - [Installation](#installation)
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
  - [Eureka](https://github.com/Netflix/eureka)
  
  ## Installation
  
 - Installing Git:
```
$apt-get install git
```
  
  - Clone the project from github:
```
$git clone https://github.com/daniaraujo/jts.cloud-native.2019.2/tree/temafinal2
```

 - Clone Netflix Eureka repository:
```
$git clone https://github.com/Netflix/eureka.git
```

 - 

   ## Authors
   
   
   **Antonio Marcos Silva de Azambuja** -  [GitHub](https://github.com/antonioazambuja)
   
   <a href="https://github.com/fabioqmarsiaj">
        <img 
        alt="Imagem do Autor Fabio Marsiaj" src="https://avatars3.githubusercontent.com/u/45765571?s=460&v=4
" width="100">
   </a>
   
   **Fabio Quinto Marsiaj** -  [GitHub](https://github.com/fabioqmarsiaj)
   
   <a href="https://github.com/fabioqmarsiaj">
        <img 
        alt="Imagem do Autor Fabio Marsiaj" src="https://avatars0.githubusercontent.com/u/34289167?s=460&v=4" width="100">
  </a>
  
