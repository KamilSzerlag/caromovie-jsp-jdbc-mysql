# caromovie-jsp-jdbc-mysql

Project based on:
- Tomcat 9
- MySQL
- Servlet
- JSP

Can be described as CRUD application, but in the future I will try add connection 
with external API like The MovieDB API.

How to start Application:
- install Tomcat 9
- add .war artifact to < tomcat- application>/webapps
- run MySQL server
- run Tomcat 9


Create User in MySQL:
```sql
CREATE USER 'webmovieuser'@localhost IDENTIFIED BY 'webusermovie';

GRANT ALL PRIVILEGES ON * . * TO 'webmovieuser'@'localhost';
```

Create Table in MySQL:
```sql
CREATE DATABASE  IF NOT EXISTS `movie_user_database` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `movie_user_database`;

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movie` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(45) NOT NULL,
    `year` VARCHAR(45) DEFAULT NULL,
    `watched` BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (`id`)
)  ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=LATIN1;

```

If you have problems with MySQL auth use:
```sql
alter user 'webmovieuser'@'localhost' identified with mysql_native_password by 'webmovieuser';
```

When your Tomcat is running open ```http://localhost:8080/```

