# springboot-angular

Task1 : As part of application startup we read csv flatfile and write to employee table

Task2 : Create Employee crud and Ui for add employee and list employee

Task3 : Login and sign up pages

# Employee Inventory backend

Employee UI spring boot application.

    -> Employee crud API's
    
    -> Admin Details CRUD

Run the Application:

Step1). Install docker if not exists - https://docs.docker.com/engine/install/

Step2). -> Navigate to application folder 

        -> docker container prune  -> enter 'y' (this needed for running application second time)

        -> Run command "docker-compose -f docker-compose-only.yml up" to start dependencies
        
Step3). Run the spring boot application from IDE (STS) or open cli and run "mvn spring-boot:run"

Step3). SwaggerUI for documentation - http://localhost:8090/emp-inv/swagger-ui.html

Step4). Start the employee-ui angular project 



# Run employee-ui

This project was generated with Angular CLI version 6.0.8.

Run the application locally

Step1). After running employee-inventory spring boot application try to run UI

Step2). Open CLI and navigate to employee-ui (angular project)

Step3). Run ng serve --open for a dev server. Navigate to http://localhost:4200/.
