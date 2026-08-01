# Spring Data JPA

JPA stands for Java Persistence API. 

```shell
//Instead of writing SQL, you write repository.save(user);

Application
      │
Spring Data JPA
      │
Hibernate
      │
Database
```

## Hibernate

Hibernate is the most popular implementation of JPA

### @Entity

This annotation tells Hibernate that this java class represents a database table.

```java
// every row becomes new User(...)

@Entity
// @Table(name="users") // used to map to different table, as by default will map to user
public class User {

    @Id
    private Integer id;
    private String name;
    private Integer age;

}
```

### @Id

Every entity needs a primary key

```java
// database generates 1,2,3..
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
```

### @Column

Customizes a column

```java
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="full_name") // saves name in DB as full_name
    private String name;
    
    private Integer age;

}
```

### @Respository

```java
@Repository
public interface UserRepository
        extends JpaRepository<User,Integer> {

}

Once you extens JpaRepository, you automatically get

save()
findById()
findAll()
delete()
count()
existsById()
```