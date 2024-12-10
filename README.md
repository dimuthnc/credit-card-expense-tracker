# Getting Started
Documentation is under construction

# Purpose
The purpose of this repository is to create a backend REST API service using Spring Boot to store the credit card transactions of a user. The end goal of this project is to create a web application that helps users to
1. Self-evaluate their credit card expenditures on their credit card cycle
2. Set a maximum expenditure goal and track the current expenses based on the goal.
3. Set a maximum expenditure goal and display a current daily limit
4. Get a detailed view of credit card expenditures based on the categories
5. Many more features

# Running the application
This application requires a postgres database instance to store the data.

You can start the application in several ways. Some of them are as below

1. Start the compose.yml file in the repo. ( This is the easiest way IMO)

Start both postgres db and application using the compose.yml in the root directory of the repository as below
`docker-compose -f componse.yml up`
Notes
 - Most of the IDEs such as IntelliJ IDEA support running compose files via UI as well
 - Update the required parameters in the compose file such as username, password etc
2. Start the postgres db using docker compose file and then start the application locally.

You can use the same compose file to only start the DB (will be easier via a UI in IDE). You can comment the application section and create your own componse file as well.
Then start the application using the below command
`mvn spring-boot:run`
Make sure to update the application.properties file or provide the required property values before starting this application locally