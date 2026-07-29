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