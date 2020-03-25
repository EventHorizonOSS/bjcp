# BJCP

BJCP REST API implemented with  Spring Web MVC

## Requirements

* Java 11
* Maven 3.0.5
* Docker 19.03.5
* Docker-compose 1.24.1

## Set UP

Assuming Java is installed at /opt/jdk-11.0.5:

```shell script
export JAVA_HOME=/opt/jdk-11.0.5
```

## Build

```shell script
mvn clean install
```

## Build Docker Images

```shell script
cd ./docker/bjcp
docker build -t bjcp .
cd ./docker/mongo
docker build -t mongo .
```

## Run

```shell script
cd ./docker
docker-compose -f docker-compose.yml up
```

## Run Tests

### Unit tests

```shell script
mvn clean verify -P UnitTests
```

### Integration tests

```shell script
mvn clean verify -P IntegrationTests
```

## Versions Plugin

Check plugin updates:
```shell script
mvn versions:display-plugin-updates
```

Check dependency updates:
```shell script
mvn versions:display-dependency-updates
```

## License

[LICENSE](./LICENSE)
