#!/usr/bin/env bash

mvn clean
mvn package
mv target/test.jar docker/java/

docker-compose build
