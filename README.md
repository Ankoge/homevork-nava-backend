# Nava Homework Backend

## Description

The backend part of a picture viewer api. I'm the [frontend](https://github.com/Ankoge/homework-nava-frontend) if you miss me.

## Language and Tools

<a href="https://www.mysql.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original-wordmark.svg" alt="mysql" width="40" height="40"/> </a>
<a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a>

## How To Run

Install [MySQL](https://dev.mysql.com/doc/refman/8.0/en/installing.html)

You will need a database and a user with password for MySQL.



Install [Java OpenJdk 11](https://openjdk.org/projects/jdk/11/)

Install Maven:

```shell
$ mvn install
```

Run:

```shell
$ mvn -Dspring-boot.run.jvmArguments="-Dspring.datasource.url={connection-string}" spring-boot:run
```

Connection-string example, substitute the username, password and database name with your ones.

```text
spring.datasource.url=jdbc:mysql://{username}:{password}@localhost:3306/{database_name}
```