# ArchiWebNomadisme Quarkus project

## Creating Maven wrapper

Execute at the project root
```shell script
mvn -N io.takari:maven:wrapper -Dmaven=3.6.3
```

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

## Using the application

### Get the list of bikes

> GET request

http://localhost:8081/bikes

### Changing a bike's owner

> PUT request

http://localhost:8082/owners/{bike identification}
> BODY
```json
{
  "owner": "XXXX"
}
```

