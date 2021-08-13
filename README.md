# MySQL Development Skeleton
This is a skeleton repository to start developing a database with MySQL.

## Requirements
You need to be able to use "docker-compose".
- Docker Engine: 19.03.0 or above
    - https://matsuand.github.io/docs.docker.jp.onthefly/compose/compose-file/

## Execute
1. Type the following command in the project root directory to start the container.
    ```
    docker-compose up -d
    ```
2. Enter the following command to enter the migrate container.
    ```
    docker-compose exec migrate bash
    ```
3. In the migrate container, use the gradle wrapper to run the flyway task with a command like the following.
    ```
    (Example)
    ./gradlew flywayBaseline
    ./gradlew flywayInfo -i
    ./gradlew flywayMigrate
    ...
    ```
    Flyway Tasks Reference
    - https://flywaydb.org/documentation/usage/gradle/

## Specify an environment identifier
You can set multiple database connection information in `"gradle.properties"`.  
The connection information defined here is used by specifying the environment name in the project property `"env"` when executing the gradle command as shown below. (Defaults to `"local"` if not set.)
```
(Example)
[gradle.properties]
develop.flyway.url = jdbc:mysql://xxx.xxx.xxx.xxx:3306/develop_db
develop.flyway.user = flyway
develop.flyway.password = password

[command]
./gradlew flywayMigrate -Penv=develop
```
