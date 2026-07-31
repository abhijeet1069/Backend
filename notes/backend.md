# Spring Topics for Backend Development

## 1. Spring Core (Must Know)

-   IoC (Inversion of Control)
-   Dependency Injection
-   Bean lifecycle
-   Bean scopes
    -   Singleton
    -   Prototype
    -   Request
    -   Session
-   Component scanning
-   `@Component`
-   `@Service`
-   `@Repository`
-   `@Controller`
-   `@Configuration`
-   `@Bean`
-   Constructor injection
-   `@Autowired`
-   `@Profile`
-   `@Value`
-   `@ConfigurationProperties`

------------------------------------------------------------------------

## 2. Spring Boot

-   Auto Configuration
-   Starters
-   Embedded Tomcat
-   SpringApplication
-   `application.properties` / `application.yml`
-   Profiles
-   External configuration
-   Logging
-   DevTools
-   Actuator
-   Fat JAR packaging

------------------------------------------------------------------------

## 3. Spring MVC

-   DispatcherServlet
-   Request lifecycle
-   REST API design
-   Controllers

### Annotations

-   `@RestController`
-   `@Controller`
-   `@RequestMapping`
-   `@GetMapping`
-   `@PostMapping`
-   `@PutMapping`
-   `@DeleteMapping`

### Request Binding

-   `@PathVariable`
-   `@RequestParam`
-   `@RequestBody`
-   `@RequestHeader`

### Responses

-   `ResponseEntity`
-   `HttpStatus`

### Validation

-   `@Valid`
-   `@NotNull`
-   `@NotBlank`
-   `@Size`

### Exception Handling

-   `@ControllerAdvice`
-   `@ExceptionHandler`

### JSON

-   Jackson serialization/deserialization

------------------------------------------------------------------------

## 4. Spring Data JPA

### Entities

-   `@Entity`
-   `@Table`
-   `@Id`
-   `@GeneratedValue`
-   `@Column`

### Relationships

-   `@OneToOne`
-   `@OneToMany`
-   `@ManyToOne`
-   `@ManyToMany`

### Repositories

-   `JpaRepository`
-   `CrudRepository`
-   `PagingAndSortingRepository`

### Queries

-   Derived query methods
-   JPQL
-   Native SQL
-   Pagination
-   Sorting

### Persistence

-   `@Transactional`
-   Lazy vs Eager loading
-   N+1 problem
-   Cascade types
-   Fetch types
-   Persistence Context
-   Dirty checking
-   Entity lifecycle
-   Optimistic locking

------------------------------------------------------------------------

## 5. Spring Security

-   Authentication
-   Authorization
-   BCrypt
-   JWT
-   Session authentication
-   Role-based authorization
-   Filters
-   `SecurityFilterChain`
-   `UserDetailsService`
-   OAuth (basics)

------------------------------------------------------------------------

## 6. Testing

-   JUnit 5
-   Mockito
-   MockMvc
-   `@SpringBootTest`
-   `@WebMvcTest`
-   `@DataJpaTest`
-   TestContainers (bonus)

------------------------------------------------------------------------

## 7. Spring AOP

-   Aspect
-   Advice
-   Pointcut
-   Join Point
-   Before
-   After
-   Around Advice
-   Logging
-   Security
-   Transactions

------------------------------------------------------------------------

## 8. Transactions

-   ACID
-   Propagation
-   Isolation
-   Rollback
-   Read-only transactions
-   Nested transactions
-   Distributed transactions (overview)

------------------------------------------------------------------------

## 9. Validation

-   Bean Validation
-   Hibernate Validator
-   Custom validators
-   Constraint annotations
-   Global exception handling

------------------------------------------------------------------------

## 10. Caching

-   `@Cacheable`
-   `@CachePut`
-   `@CacheEvict`
-   Redis integration

------------------------------------------------------------------------

## 11. Scheduling & Async

-   `@Scheduled`
-   `@EnableScheduling`
-   `@Async`
-   `CompletableFuture`
-   Thread pools
-   `TaskExecutor`

------------------------------------------------------------------------

## 12. Spring Events

-   Application Events
-   Custom Events
-   `@EventListener`

--------------------------- POST THIS START YOUR PROJECT --------------------

## 13. Spring Boot Actuator

-   Health endpoints
-   Metrics
-   Info endpoint
-   Micrometer
-   Prometheus integration

------------------------------------------------------------------------

## 14. Spring Cloud (Microservices)

-   Config Server
-   Eureka Service Discovery
-   API Gateway
-   OpenFeign
-   Resilience4j
-   Load balancing
-   Distributed configuration
-   Centralized logging
-   Distributed tracing (overview)

------------------------------------------------------------------------

## 15. Production Topics

-   HikariCP
-   Flyway / Liquibase
-   Configuration management
-   Logging
-   Monitoring
-   Health checks
-   Graceful shutdown
-   Docker support
-   Environment variables
-   Secrets management

------------------------------------------------------------------------

# Optional (Learn Later)

-   Spring WebFlux
-   Spring Batch
-   Spring Integration
-   Spring LDAP
-   Spring Web Services (SOAP)
-   Spring AMQP
-   Spring Kafka
-   Spring Native
-   Spring AI
