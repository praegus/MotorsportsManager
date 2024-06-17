#!/bin/sh

set -e

cd ./motorsports-manager-backend
mvn clean compile spring-boot:run
