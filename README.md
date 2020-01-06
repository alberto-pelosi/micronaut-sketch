# micronaut-sketch

Simple application to learn micronaut.

The application is a CRUD microservice on PRODUCT and MANUFACTURER tables.

Every time a product detail is required, the microservice sends a message to a RabbitMQ queue and a RabbitMQ consumer listening on another microservice reads the message and saves it on db.

The purpose is to learn micronaut, and in particular micronaut-data and micronaut-rabbitmq.

To use micronaut, read the [quick start section](https://docs.micronaut.io/latest/guide/index.html#quickStart) of micronaut documentation.
