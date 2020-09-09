# test-igaming

### Description

- As DB used H2. For current implementation it should be easily change to Postgres or other DB.
- for data migration (initial load) used flyway
- added swagger support
- h2 console available via `http://localhost:8080/h2-console` 
and db-url: `jdbc:h2:mem:testdb`, user: `sa`, password: `password`
- health check available via `/actuator/health`. Other benefit from actuator just need to enable
- for dto 2 domain entity used mapstruct
- used simplified view of price - without currency and fractional numbers
- Dockerfile available as a draft
- Test are not implemented

### How to run

To run application use `gradlew bootRun` or `gradlew.bat bootRun`

Swagger ui available by default path `/swagger-ui/`.

For accessing rest used default spring boot http port `8080`.

So if you execute via `bootRun` from local machine - you can observe api by URL http://localhost:8080/swagger-ui/ (make sure tailing slash)

### TODO
- in case of high load and may be efficient implementing CQRS or at least use asynchronous API
- add sleuth
- use webflux instead of blocking controllers (and react approach in whole project service + db)
- add BDD test (cucumber) may be based on testcontainers
- generate rest docs based on tests