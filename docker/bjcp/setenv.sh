#!/usr/bin/env bash

DATA_BASE="/data/tomcat"

export CATALINA_OPTS="\
-Djavax.net.ssl.trustStore=$DATA_BASE/certs/truststore \
-Djavax.net.ssl.keyStore=$DATA_BASE/certs/keystore \
-Djavax.net.ssl.trustStorePassword=changeit \
-Djavax.net.ssl.keyStorePassword=changeit \
-Dcom.sun.management.jmxremote=true \
-Dcom.sun.management.jmxremote.port=6001
-Dcom.sun.management.jmxremote.rmi.port=6003 \
-Dcom.sun.management.jmxremote.ssl=false \
-Dcom.sun.management.jmxremote.ssl.need.client.auth=false \
-Dcom.sun.management.jmxremote.registry.ssl=false \
-Dcom.sun.management.jmxremote.authenticate=false \
-Dcom.sun.management.jmxremote.access.file=$DATA_BASE/config/jmxremote.access \
-Dcom.sun.management.jmxremote.password.file=$DATA_BASE/config/jmxremote.password \
-Djava.rmi.server.hostname=bjcp.eventhorizon.com.br \
-Dbr.com.eventhorizon.bjcp.mongo.serveraddress=$MONGO_SERVER_ADDRESS \
-Dbr.com.eventhorizon.bjcp.mongo.port=$MONGO_SERVER_PORT \
-Dbr.com.eventhorizon.bjcp.mongo.database=$MONGO_DATABASE \
-Dbr.com.eventhorizon.bjcp.mongo.authdatabase=$MONGO_AUTH_DATABASE \
-Dbr.com.eventhorizon.bjcp.mongo.username=$MONGO_AUTH_USERNAME \
-Dbr.com.eventhorizon.bjcp.mongo.password=$MONGO_AUTH_PASSWORD"