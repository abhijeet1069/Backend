# Spring framework

Spring was an alternative to EJB which was very heavyweight.

Spring introduced three revolutionary ideas:

* IoC (Inversion of Control)
* Dependency Injection (DI)
* Aspect Oriented Programming (AOP)

```shell
                    Spring Framework
                           │
 ┌─────────────┬──────────────┬──────────────┬─────────────┐
 │             │              │              │             │
 Core        AOP           Data          Web MVC      Security
 │             │              │              │             │
 Beans      Logging       JDBC/JPA      REST APIs    Authentication
 Context    Transactions  Hibernate     Controllers  Authorization
```

## Spring Bean

A bean is simply an object that is created, configured and managed by the Spring IOC container.

## Lifecycle

1. Bean Definition Loaded
          ↓
2. Bean Created (Instantiation)
          ↓
3. Dependencies Injected
          ↓
4. Initialization Callbacks
          ↓
5. Bean Ready for Use
          ↓
6. Bean Destroyed (on shutdown)

## Bean Scopes

Bean scopes tell Spring how long a bean should live and how many instances Spring should create.

Scope answers the question, "Should Spring create one object, a new object every time, 
one per HTTP request, or one per user session?"

  Scope         Instances          Lifetime
  ------------- ------------------ ----------------------------
  Singleton     1                  Entire application
  Prototype     New every lookup   Until no references remain
  Request       1                  HTTP request
  Session       1                  HTTP session
  Application   1                  Web application
  WebSocket     1                  WebSocket connection

## Component Scanning

Component scanning is the process by which Spring automatically detects classes annotated with 
stereotypes like @Component, @Service, @Repository, and @Controller, creates their objects, and 
registers them as beans in the IoC container.

```java
//enables component scanning
@SpringBootApplication

//above annotations includes these annotations
@Configuration
@EnableAutoConfiguration
@ComponentScan
```

```java
// annotations which are discovered

@Component
@Service
@Repository
@Controller
@RestController
```

## Contructor Injection

Constructor Injection is a form of **Dependency Injection (DI)** where
Spring provides the required dependencies through a class constructor
when creating the bean.

Instead of creating dependencies using `new`, the class asks Spring to
provide them.

## Mental Model

```shell
                @SpringBootApplication
                         │
                         ▼
               Component Scanning
                         │
         ┌───────────────┼────────────────┐
         ▼               ▼                ▼
   @Repository      @Service      @RestController
         │               │                │
         │               │                │
         └────── Constructor Injection ───┘
                         │
                         ▼
                  IoC Container
                         │
                  (Singleton Beans)
                         │
                         ▼
                 Handles HTTP Requests

```