GWT-Resty-Template
==================

A GWT maven template using the following libs. Feel free to fork !!! Any comment will be be appreciated. 

This template uses resty to geneate a REST client service and call the server using a GET request. 

The server uses Jersey + Guice to handle resources and send back responses as Json messages.


Client
-------
  + RestyGWT 

Server
--------
  + Guice
  + Jersey 1.17 (JAX-RS)
  
How to use
==================
Fork it.

Clone it.

Using eclipse
-------------
Import the project as an existing maven project. The pom is located under GWT-Resty-Template\template\rq.restygwt.template

Using Maven
-----------
mvn clean package
mvn gwt:run
