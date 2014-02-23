**This project is obsolete!**

Please refer https://github.com/terasolunaorg/terasoluna-gfw-web-blank


----

Web App Example Using Spring MVC & Spring Data JPA

for MySQL(default)

$ mvn clean test -P mysql
$ mvn clean eclipse:clean eclipse:eclipse -P mysql

for PostgreSQL

$ mvn clean test -P postgresql
$ mvn clean eclipse:clean eclipse:eclipse -P postgresql

for H2

$ mvn clean test -P h2
$ mvn clean eclipse:clean eclipse:eclipse -P h2

for HSQLDB

$ mvn clean test -P hsqldb
$ mvn clean eclipse:clean eclipse:eclipse -P hsqldb

tested only on Tomcat7 (not use JTA)

$ mvn clean tomcat7:run -P h2
access http://localhost:8080/springmvc-jpa-blank

