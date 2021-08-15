# PostgreSQL Development Skeleton

This is a skeleton repository to start developing a database with PostgreSQL.

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
   1. Create a baseline in the target database. (First time only).
      ```
      ./gradlew flywayBaseline
      ```
   2. Build the migrate file.
      ```
      ./gradlew build
      ```
   3. Check the status information of the migration.
      ```
      ./gradlew flywayInfo
      ```
   4. Execute the migration.
      `./gradlew flywayMigrate`
      For more information about the Flyway task, please refer to the following.
   - https://flywaydb.org/documentation/usage/gradle/

## Specify an environment identifier

You can set multiple database connection information in `"gradle.properties"`.  
The connection information defined here is used by specifying the environment name in the project property `"env"` when executing the gradle command as shown below. (Defaults to `"local"` if not set.)

```
(Example)
[gradle.properties]
develop.flyway.url = jdbc:postgresql://xxx.xxx.xxx.xxx:5432/develop_db
develop.flyway.user = flyway
develop.flyway.password = password

[command]
./gradlew flywayMigrate -Penv=develop
```
