# Manulo backend

## Building project
Using gradle wrapper:

- `gradlew clean build`

## Environments (TO UPDATE)
- `dev` (`http://XXXXXXXXXX:####/manulo-dev`)
- `test` (`http://XXXXXXXXXX:####/manulo-test`)
- `stg` (`http://XXXXXXXXXX:####/manulo-stg`)
- `prd` (`http://XXXXXXXXXX:####/manulo-prd`)

To activate a profile, use gradle project property called `env`, e.g. `gradlew build -Penv=prd`

By default `dev` is active, so without explicit project property it will be used.
If you provide profile different than one of the above or default, build will fail.

## Maintenance
To upgrade gradle wrapper run:

`gradlew wrapper --gradle-version 4.10`

## Databases
There is only in-memory database available for now - H2.

## Actuator
Boot module has dependency on Spring Actuator with following endpoints enabled and exposed via web:

- `GET .../actuator`
- `GET .../actuator/info` (returns some metadata about running app)
- `GET .../actuator/health` (simple healthcheck)
- `POST .../actuator/shutdown` (shuts the app down)

These endpoints should be protected and not accessible from the outside in production environment.