# Spring3Hibernate - A OpsTree Sample Maven based Java Application

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