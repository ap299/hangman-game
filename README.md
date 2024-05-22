# hangman-game
 
HangOut & Hangman is a multiplayer Hangman game built with Java Spring Boot, offering real-time communication using WebSockets. The application allows users to create accounts, join game rooms, and play the classic game of Hangman with a twist: it's multiplayer! This document outlines key design choices, technologies used, and provides comprehensive instructions on setting up and testing the game.

-Key Design Choices

  Backend Framework:
  Spring Boot: Chosen for its robust ecosystem, ease of configuration, and powerful tools for creating RESTful APIs.
  
  Spring Security: Utilized for user authentication and authorization.
  
  Database:
  MySQL: Selected for its reliability and integration with Spring Boot via JPA and Hibernate.
  
  Real-Time Communication:
      WebSockets: Used to facilitate real-time updates between players in a game room.
  
  Template Engine  
      Thymeleaf: Used for rendering HTML templates on the server-side.
  
  Frontend:HTML, CSS, and JavaScript: Basic frontend technologies for the UI.

-Technologies Used
    Spring Boot
    Spring Security
    Spring Data JPA
    WebSockets
    Thymeleaf
    MySQL
    Maven


1.Clone the Repository:

    git clone https://github.com/ap299/hangman-game.git
    cd hangman-game

2.Configure the Database:

  -Create a MySQL database named hangman:

    CREATE DATABASE hangman;
    CREATE USER 'hangmanuser'@'localhost' IDENTIFIED BY 'password';
    GRANT ALL PRIVILEGES ON hangman.* TO 'hangmanuser'@'localhost';
    FLUSH PRIVILEGES;

#Accessing the Application
    Home: http://localhost:8080
    Register: http://localhost:8080/users/register
    Login: http://localhost:8080/users/login
    Create Room: http://localhost:8080/rooms/create-room
    Join Room: http://localhost:8080/rooms/join-room
    Game: http://localhost:8080/game?roomId={roomId} (replace {roomId} with the actual room ID)
    Leaderboard: http://localhost:8080/leaderboard

API Documentation(Response: 200 OK on success, 404 Not Found)
  -User Registration
    {
    "username": "newuser",
    "password": "password"
    }

  -User Login
    {
    "username": "existinguser",
    "password": "password"
    }

  -Create Game Room
    {
    "roomId": "uniqueRoomId"
    }

  -Join Game Room (use another tab)
    {
    "roomId": "existingRoomId"
    }

Testing the Application
  Register a New User:
    Navigate to the registration page and create a new user.
  
  Login: 
    Login with the newly created user credentials.
  
  Create a Game Room:  
    After logging in, create a new game room.
  
  Join a Game Room:
    Open a new browser tab or window, login with another user, and join the previously created game room.
  
  Play the Game: 
    Take turns guessing letters and watch the game state update in real-time.

Bonus Features
  Enhanced Security: Passwords are hashed using BCrypt.
  Leaderboard: Displays top players based on scores.
  




