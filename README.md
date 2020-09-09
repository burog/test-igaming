# test-igaming

### Description

- As DB used H2. For current implementation it should be easily change to Postgres or other DB.
- for data migration (initial load) used flyway
- added swagger support
- health check available via `/actuator/health`
- for dto 2 domain entity used mapstruct
- Dockerfile available as a draft
- Test are not implemented

### How to run

To run application use `gradlew bootRun` or `gradlew.bat bootRun`

Swagger ui available by default path `/swagger-ui/`.

For accessing rest used default spring boot http port `8080`.

So if you execute via `bootRun` from local machine - you can observe api by URL http://localhost:8080/swagger-ui/ (make sure tailing slash)

### TODO
- add sleuth
- use webflux instead of blocking controllers (and react approach in whole project service + db)
- add BDD test (cucumber) may be based on testcontainers
- generate rest docs based on tests