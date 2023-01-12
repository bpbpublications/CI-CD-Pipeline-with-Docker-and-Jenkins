# CI/CD Pipeline with Docker and Jenkins

A Practical Guide to Mastering Modern-day Software Development

This is the repository for [CI/CD Pipeline with Docker and Jenkins
](https://bpbonline.com/products/ci-cd-pipeline-with-docker-and-jenkins-1). 

## About the Book
‘CI/CD Pipeline with Docker and Jenkins’ is the right mix of narrative, concepts, and real-life implementation. The book focuses on the CI/CD maturity journey of a team from a DevOps perspective. 

The book takes you on a CI/CD journey of a project, starting from identifying the challenges faced by the team and how the team uses CI as a first step to overcome the problems. Moving on, the book explains how the team matures via the Jenkins shared library and Dockerization. The later part of the book covers the next journey, where the DevOps team decides to introduce CD to mature the DevOps practices of the project further.  Here, the book explains how the DevOps team learns about the various implementations of CD and applies them via Jenkins. Given that there are multiple technologies to cover, the journey starts from the simplest one and slowly goes on to higher concepts ensuring that you follow the right learning path.

To keep things in perspective, a sample project has been included with the book, and all the concepts of CI/CD are implemented in it. You can work with it, test out different scenarios, and can refer to them for your projects.

## What You Will Learn
•  Design a CI implementation plan in terms of Pre and Post Deployment integration checks.

•  Learn how to run your CI/CD jobs in Docker containers.

•  Understand how CI and CD work together end to end to achieve modern software delivery goals.

•  Design and implement a very comprehensive CI process of any stack on any platform.

•  Assess and identify the CD requirements of a project and architect the right CD solution. 


## Spring3Hibernate - A OpsTree Sample Maven based Java Application

The main goal of this awesome Java Webapp is to encourage people to dive deep in Java Application Architecture and how we can make delivery pipeline faster, easier and much reliable using **Continous Integration**.

## Dependencies

The list of dependencies are not quite long but yes we do have some dependencies.

- [X] **Maven 3.X**
- [X] **Java 8**
- [X] **MySQL**
- [X] **Docker**(Only if you are willing to create a Dockerized Setup)

## Needs to be Taken Care
This application connects with MySQL database. If you want to have a full-fledged running application, just do me a favor and edit these properties according to your database environment.

```properties
database.driver=com.mysql.jdbc.Driver
database.url=jdbc:mysql://mysql.okts-test:3306/employeedb
database.user=root
database.password=password
hibernate.dialect=org.hibernate.dialect.MySQLDialect
hibernate.show_sql=true
hibernate.hbm2ddl.auto=update
upload.dir=c:/uploads
```

**Note:- The location of file is [src/main/resources/database.properties](src/main/resources/database.properties)**

## How to Run

#### Manual Setup

Running this application manually is pretty straight forward.

**For Compilation**

```shell
mvn clean package
```

**For Unit Tests**

```shell
mvn test
```

**For Deploying Artifact on Remote Repository**

```shell
mvn deploy
```

There is some other cool stuff as well but I leave that up to you to explore it.

#### Dockerized Setup

Dockerized setup is much classier than manual setup. To achieve this you just have to do this:-

```shell
docker build -t opstree/spring3hibernate:latest -f Dockerfile .
```

That's it. It will create Tomcat Image having the war itself. Now just go and deploy the docker image anywhere you want.

#### Docker Compose Setup

```shell
docker-compose build
docker-compose up 
```

The compose file will spinup three containers:
1) Nginx (Ingress)
2) Spring3Hibernate (JAVA APP)
3) MySql (Database)
