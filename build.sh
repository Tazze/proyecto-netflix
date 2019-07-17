#!/bin/sh
#CLEANING
mvn clean -f config/pom.xml
mvn clean -f eureka/pom.xml
mvn clean -f modelo/pom.xml
mvn clean -f mvc/pom.xml
mvn clean -f restjpa/pom.xml
#BUILDING
mvn package -f config/pom.xml
mvn package -f eureka/pom.xml
mvn install -f modelo/pom.xml
mvn package -f mvc/pom.xml
mvn package -f restjpa/pom.xml
#DOCKER
docker build --rm -f "config/Dockerfile" -t config:latest config
docker build --rm -f "eureka/Dockerfile" -t eureka:latest eureka
docker build --rm -f "mvc/Dockerfile" -t mvc:latest mvc
docker build --rm -f "restjpa/Dockerfile" -t restjap:latest restjpa