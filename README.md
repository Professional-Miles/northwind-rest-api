# Northwind-REST-API
Week 7 Rest API development Project

---

### Table of Contents :

- ##### Introduction.
- ##### Prerequisites.
- ##### How to install the Rest API.
- ##### How to use the API.
- ##### Swagger UI.
- ##### Contributors.
- ##### Future additions.
- ##### Some thoughts.

---

### Introduction:

This project is an uncomplete implementation of a REST API for the Northwind database. The database is hosted locally using MySQL Workbench and is connected to an IDE so the data can be accessed and operated on.

---

### Pre-requisites:

To run this project at least `java` 17 is required. A suitable IDE that supports `java` and dependencies for Maven, Spring, MySQL connector or a connector for your choice of DBMS among others. A DBMS, a Northwind SQL file, a viewer for URL results such as a web browser or Postman.

---

### How to install the REST API:

Either copy and clone the GitHub repository to your local git or download the files to a directory of your choice.

Once that is done, you can open the project via the compatible IDE of your choice.

---

### How to use the API:

Make sure the Northwind database has been imported to the database IDE of your choice and the schema is available. The dependencies are recognized. Your database IDE is running a local or remote server, your `java` IDE is connected to the database and the program is running.

Once that is done simply Goto mapped URL to query and/or get results related to data in the Northwind database.
Swagger UI has also been configured which you can use to view available query endpoints outside of the code base and run queries to receive results.

---

### Swagger UI:

Swagger UI has been made use of to supply documentation for the API. But due to the method of implementation certain aspects have not been properly documented such as the DTO Models due to Spring configuration. Methods also had to be refactored to have unique endpoints rather than be simple queries so they can be documented.

---

### Contributors:

Professional-Miles

---

### Future additions:

- Implementation of methods for other database tables.
- Testing of implemented methods.
- Clean up of Swagger UI configuration.
- Refactor of methods to aid documentation of Swagger UI.

---

### Thoughts:
