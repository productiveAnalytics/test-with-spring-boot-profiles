Spring boot application to demonstrate dynamic DI. The application needs one parameter, that acts as city to search.

To run as Java Application: 
   need VM parameter: -Dspring.profiles.active=dev or -Dspring.profiles.active=prod 

To run as Gradle bootRun task:
   ./gradlew -Dspring.profiles.active=dev :DI-POC:bootRun
   
To perform full build (Must pass Profile=test):
   ./gradlew -Dspring.profiles.active=test :DI-POC:build

