#!/bin/sh
#MAVEN
mvn clean package -DskipTests -f config/pom.xml
mvn clean package -DskipTests -f eureka/pom.xml
mvn clean install -DskipTests -f modelo/pom.xml
mvn clean package -DskipTests -f mvc/pom.xml
mvn clean package -DskipTests -f restjpa/pom.xml
#DOCKER
docker build --rm -f "config/Dockerfile" -t config:latest config
docker build --rm -f "eureka/Dockerfile" -t eureka:latest eureka
docker build --rm -f "mvc/Dockerfile" -t mvc:latest mvc
docker build --rm -f "restjpa/Dockerfile" -t restjap:latest restjpa