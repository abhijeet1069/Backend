# Spring MVC

## Request Lifecycle

```shell
# A request in browser would look like
GET /users/5

Browser
   │
   ▼
Embedded Tomcat (accepts the TCP connection and parses HTTP request. Tomcat creates HttpServletRequest 
   |             and HTTP serverlet response)
   │
   ▼
Servlet Filter Chain (Filters are involved in Logging, Authentication, CORS and Compression.
   |                   A filter can even reject a request)
   │
   ▼
DispatcherServlet (Assigns controller to the request). --> ExceptionResolver 
   │
   ▼
Handler Mapping (Which handler invokes which function. For ex GetMapping below)
   |                 @GetMapping("/users/{id}")
   |                 public User getUser(...)
   │
   ▼
Handler Adapter (Prepares controller call, "5" to int id = 5)
   │
   ▼
Interceptor (preHandle)
   │
   ▼
Controller
   │
   ▼
Service (Business logic)
   │
   ▼
Repository (Talk to DB)
   │
   ▼
Database
   │
   ▼
Repository
   │
   ▼
Service
   │
   ▼
Controller
   │
   ▼
HttpMessageConverter (Jackson)
   │
   ▼
Interceptor (postHandle / afterCompletion. Useful for logging, metrics or cleanup)
   │
   ▼
DispatcherServlet (returns response)
   │
   ▼
Filters (Measure response time, add headers and compress response)
   │
   ▼   
Tomcat (send HTTP response)
   │
   ▼
Browser
```

## Annotations

### @Controller 

Marks a class as a spring MVC controller

```java
// mainly used for server side rendered web applications (JSP, Thymeleaf,FreeMarker etc)
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
```

### @RestController 

Instead of returning a view, Spring converts the return value into JSON (or XML).

```java

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public List<User> getAll() { }

    @GetMapping("/{id}") //read data
    public User getOne(@PathVariable int id) { }

    @PostMapping //create new data
    public User create(@RequestBody User user) { }

    @PutMapping("/{id}") //replace ot update data
    public User update(
            @PathVariable int id,
            @RequestBody User user) { }

    @DeleteMapping("/{id}") //delete data
    public void delete(
            @PathVariable int id) { }
}

// @RestController is shorthand for
@Controller
@ResponseBody
```

## Request Binding

These annotations allow Spring to automatically extract information from an HTTP request and 
pass it into your controller method.

###  @PathVariable 

Used to extract values from URL path

```java
GET /users/10

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return service.getUser(id);
    }
}

//multiple path variables
@GetMapping("/{userId}/orders/{orderId}")
public Order getOrder(
        @PathVariable int userId,
        @PathVariable int orderId) {

}
```

### @RequestParam 

Extracts query parameters

```java
GET /users?page=2&size=20

@GetMapping("/users")
public List<User> getUsers(
        @RequestParam int page,
        @RequestParam int size) {

}

//optional parameters
@GetMapping("/users")
public List<User> getUsers(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size) {

}

```

Rule of thumb:

* PathVariable → identifies a specific resource.
* RequestParam → filters, sorting, pagination, search.

### @RequestBody

```java
POST /users
Content-Type: application/json

//body
{
    "name":"John",
    "age":25
}

//Spring using jackson maps JSON into User POJO
@PostMapping("/users")
public User createUser(
        @RequestBody User user) {

}
```

### @RequestHeader

```java
GET /users

Authorization: Bearer xyz
Client-Version: 1.0

@GetMapping("/users")
public List<User> getUsers(
    @RequestHeader("Authorization") String token,
    @RequestHeader("Client-Version") String version) {

}
```

### @ResponseStatus

Changes the HTTP status code

```java
// normally post returns 200 OK
@PostMapping("/users")

// But creating resource should return 201 created
@ResponseStatus(HttpStatus.CREATED)
@PostMapping("/users")
public User createUser(...) {

}

```

### @ResponseBody

Don't return a view, return the object itself.

```java
//without @ResponseBody spring searches for hello.html
@Controller
public class UserController {

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {

        return "Hello";
    }
}
```

### ExceptionHandler

```java
//Suppose your service throws UserNotFoundException
//Intead of crashing spring class handle()
@RestController
public class UserController {

    @ExceptionHandler(UserNotFoundException.class)
    public String handle() {

        return "User Not Found";
    }
}
```

### ControllerAdvice

Instead of writing exception handlers in every controller. Create one global handler

```java

// every controller uses below advice
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handle() {

        return ResponseEntity
                .status(404)
                .body("User Not Found");
    }
}
```

## Responses

### HttpStatus

- HttpStatus.OK : 200 Successful GET/PUT
- HttpStatus.CREATED : 201 Resource created
- HttpStatus.NO_CONTENT : 204 Success, but no response body
- HttpStatus.BAD_REQUEST : 400 Invalid client request
- HttpStatus.UNAUTHORIZED : 401 Authentication required
- HttpStatus.FORBIDDEN : 403 Authenticated but not allowed
- HttpStatus.NOT_FOUND : 404 Resource doesn’t exist 
- HttpStatus.CONFLICT : 409 Duplicate resource, version conflict
- HttpStatus.INTERNAL_SERVER_ERROR : 500 Unexpected server error

### ResponseEntity

This is a wrapper around the complete HTTP response.

```java
// Intead of returning User
// you return ResponseEntity<User>

class ResponseEntity<T> {
    HttpStatus status;
    HttpHeaders headers;
    T body;
}

// returning 201 created
@PostMapping
public ResponseEntity<User> create(
        @RequestBody User user) {

    User saved = service.save(user);

    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(saved);
}

// returning 404
@GetMapping("/{id}")
public ResponseEntity<User> getUser(
        @PathVariable int id) {

    User user = service.find(id);

    if(user == null){

        return ResponseEntity
                .notFound()
                .build();
    }
    return ResponseEntity.ok(user);
}

// returning 409 conflict
@PostMapping
public ResponseEntity<String> create(
        @RequestBody User user){

    if(repository.exists(user.getEmail())){

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body("Email already exists");
    }

    ...
}
```
