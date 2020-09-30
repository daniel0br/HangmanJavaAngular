# HangmanJavaAngular
Implementation of hangman game with Java and Angular

The folder hangman is the Angular frontend part of solution.

To run it you will need NodeJs and Angular Cli installed.

To start the application you will need to use the command:
ng serve

This command should start the Angular application on the http://localhost:4200 

You will neeed to run the application on port 4200 or you will have problems with CORS.
-- 


The folder DellTest is the Java Spring Boot backend solution.

To run it you will need to have Java installed.

To start the application you will need to generate a .jar file and execute with Java.
You can use Maven to Generate the .jar file
The appication should run on http://localhost:8080 to ensure the algular application will find the Java server endpoint

-------

The game must be player with the mouse on the application http://localhost:4200
A word will be loaded from the servera when the angular aplication starts.
The player should select the letters to guess the word.

If he miss more than 5 times he will lose, if he find all the letters he will win. 
