#!/usr/bin/env bash

export CATALINA_OPTS="\
-Dbr.com.eventhorizon.bjcp.mongo.serveraddress=$MONGO_SERVER_ADDRESS \
-Dbr.com.eventhorizon.bjcp.mongo.port=$MONGO_SERVER_PORT \
-Dbr.com.eventhorizon.bjcp.mongo.database=$MONGO_DATABASE \
-Dbr.com.eventhorizon.bjcp.mongo.authdatabase=$MONGO_AUTH_DATABASE \
-Dbr.com.eventhorizon.bjcp.mongo.username=$MONGO_AUTH_USERNAME \
-Dbr.com.eventhorizon.bjcp.mongo.password=$MONGO_AUTH_PASSWORD"