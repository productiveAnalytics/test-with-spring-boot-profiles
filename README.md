Spring boot application to demonstrate dynamic DI. The application needs one parameter, that acts as city to search.

To run as Java Application: 
   need VM parameter: -Dspring.profiles.active=dev or -Dspring.profiles.active=prod 

To run as Gradle bootRun task 
(NOTE: From Gradle prompt, bootRun cannot run with -Dspring.profiles.active=test)
   ./gradlew -Dspring.profiles.active=dev bootRun
   
To perform full build:
   ./gradlew clean build
