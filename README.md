Spring boot application to demonstrate dynamic DI. The application needs one parameter, that acts as city to search.

To run as Java Application: 
   need VM parameter: -Dspring.profiles.active=dev or -Dspring.profiles.active=prod 

To run as Gradle bootRun task
   ./gradlew -Dspring.profiles.active=dev bootRun 
(NOTE: From Gradle prompt, bootRun cannot run with -Dspring.profiles.active=test.
       i.e. Do NOT run ./gradlew -Dspring.profiles.active=test bootRun)
   
To perform full build:
   ./gradlew clean build
