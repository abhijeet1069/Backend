# Queries

## Derieved Queries

Spring reads the name of your repository method and automatically generates the SQL query for you.

Method                          Generated Query

- findByName()                  WHERE name = ?

- findByNameAndAge()            WHERE name = ? AND age = ?

- findByAgeGreaterThan()        WHERE age > ?

- findByAgeBetween()            WHERE age BETWEEN ? AND ?

- findByNameContaining()        WHERE name LIKE '%...%'

- findByDepartmentName()        JOIN department ... WHERE department.name = ?

- countByName()                 SELECT COUNT(*) ...

- existsByEmail()               Returns true/false

- deleteByStatus()              DELETE ... WHERE status = ?

```java

package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {

    //derieved queries

    Optional<Employee> findById(Long id);

    List<Employee> findByDepartmentName(String department);

    List<Employee> findByAgeGreaterThan(Integer age);

    Optional<Employee> findByEmail(String email);

    boolean existsByEmail(String email);

    long countByDepartmentName(String department);

    //JPQL
    @Query("SELECT e FROM Employee e WHERE e.salary > :salary")
    List<Employee> findHighSalaryEmployees(@Param("salary") Double salary);
}

```

## JPQL

SQL                         JPQL

Queries tables              Queries entities

Uses table names            Uses Java class names

Uses column names           Uses Java field names

Database-specific           Database-independent

SELECT * FROM employee      SELECT e FROM Employee e

## Native SQL

```java
@Repository

public interface EmployeeRepository
       extends JpaRepository<Employee, Long> {

    @Query(value = """
        SELECT *
        FROM employee
        WHERE age > :age
        """, nativeQuery = true)

    List<Employee> findOlderThan(@Param("age") Integer age);
}
```

## When should you use each?

* Derived Query Methods: For simple lookups like findByName, findByAgeGreaterThan, findByDepartmentName.

* JPQL: When the query is too complex for a derived method but can still be expressed in 
        terms of entities and   their relationships.

* Native SQL: When you need database-specific features (CTEs, window functions, JSONB, 
            recursive queries, performance tuning, etc.) or want complete control over the SQL.

## Pagination

Pagination means breaking a large result set into smaller pages. It’s one of the first things you’ll add to APIs that return lists because it improves performance and user experience.

The problem it solves is simple: What if your table has millions of rows?
You don’t want to return everything.

```shell
Client
   │
   │ GET /employees?page=1&size=10
   ▼
Controller
   ▼
Repository.findAll(PageRequest.of(1,10))
   ▼
Hibernate
   ▼
SQL:
SELECT *
FROM employee
LIMIT 10 OFFSET 10;
```