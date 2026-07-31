# Spring Boot

Spring Boot is not another framework.

It is

Spring Framework + Auto Configuration + Embedded Tomcat + Starter Dependencies

## Auto Configuration

Auto Configuration is a Spring Boot feature that automatically configures beans and infrastructure 
based on the libraries available on the classpath and the application’s configuration properties. 
It reduces boilerplate configuration and follows the convention-over-configuration principle.

## Starters

A Spring Boot Starter is a curated set of dependencies for a particular feature or type of application.

Instead of figuring out and adding 15–20 libraries yourself, you add one starter, and Spring Boot brings 
in everything needed.

## Spring profile

A Spring Profile is a mechanism that allows an application to use different configurations and beans for different environments such as development, testing, and production. The active profile determines which profile-specific properties and beans Spring loads at startup.

-- more about spring profile

## External configuration

External configuration means keep configuration outside your Java code so that you can change application
behavior without recompiling or modifying source code.

### Priority of Spring config

Higher-priority sources override lower-priority ones. From lowest to highest

- application.properties : src/main/resources/application.properties
- applcation.yml : src/main/resources/application.yml
- Profile-specific config : application-dev.yml
- External config files : outside the jar
- Environment variables : SERVER_PORT=8081
- JVM System properties : -Dserver.port=8082
- Command line arguments : --server.port=8083

## Logging

- TRACE : Extremely detailed information (mainly used for debugging)
- DEBUG : Information useful while developing (mainly used in development)
- INFO : Normal application events (mainly in prod, for important business events)
- WARN : Something unexpected, but application can continue (something isn't ideal but app can continue)
- ERROR : A failure occurred  (some serious issue like DB connection failed)

## DevTools

Spring Boot DevTools is a dependency that makes development faster and more convenient. It is not 
intended for production.

Without DevTools, every time you change your code, you have to:

1. Stop the application.
2. Rebuild it.
3. Start it again.
4. Wait for Tomcat to initialize.

## Actuator

Spring Boot Actuator is a production monitoring and management module for Spring Boot applications.

```shell
                Client
                   │
                   ▼
            Spring Boot App
                   │
        ┌──────────┴──────────┐
        │                     │
 REST Controllers      Actuator Endpoints
 (/users, /orders)     (/health, /metrics)
        │                     │
        └──────────┬──────────┘
                   ▼
               JVM Metrics
                   │
                   ▼
             Prometheus
                   │
                   ▼
               Grafana
```