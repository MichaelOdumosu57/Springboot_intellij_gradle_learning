[Complete CRUD operation using Spring boot and Gradle | MySQL | Backend](https://www.youtube.com/watch?v=Q5GGlqMVB18)

* you can create a new spring project from intellij
* in maven it's pom.xml
* in gradle its build.gradle
## build.gradle
* your deps are in the dependencies block
* implementation is deps for code
* testImplementations is for test


## Oracle DB
* [Oracle Docker Containers](https://container-registry.oracle.com/ords/f?p=113:10::::::)
* [Oracle Container Docker Images](https://github.com/oracle/docker-images/blob/main/OracleDatabase/SingleInstance/README.md)
* [How to run OracleDB in Docker](https://medium.com/@bastian.ohm/how-to-run-oracle-db-in-docker-6990780d4cac)



* after setting up the contianer
```sh
sqlplus sys/12345 as sysdba
```

* in oracle there are 2 types of database container database and pluggable,
* your work should be in pluggable container manages your database
```sql
show pdbs
alter session set container = ORCLPDB1;
CREATE USER TollySingers IDENTIFIED BY TollySingers;
grant dba to TollySingers;
ALTER USER TollySingers ACCOUNT UNLOCK IDENTIFIED BY tiger;
```
so now to log in with sqlplus
```sh

sqlplus [username]/[password]@database;
sqlplus TollySingers/tiger@ORCLPDB1;
```

* so in jpa there is the entity which represents the table
* there is the repository that allows you to interact with the table


* you can go to the [swagger](http://localhost:8095/swagger-ui.html#) and interact with the endpoints there
* [MVN Repository](https://mvnrepository.com/artifact/io.springfox/springfox-swagger2/2.9.2)
* its a great way to find and get packages

* you can use Jackson Dataformat XML dependency to change json to xml
```java
    @GetMapping(value = "/getSingleSinger/{id}",produces = {MediaType.APPLICATION_XML_VALUE})
```
