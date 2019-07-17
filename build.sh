#!/bin/sh
#MAVEN
mvn clean package -DskipTests -f config/pom.xml
mvn clean package -DskipTests -f eureka/pom.xml
mvn clean install -DskipTests -f modelo/pom.xml
mvn clean package -DskipTests -f mvc/pom.xml
mvn clean package -DskipTests -f restjpa/pom.xml