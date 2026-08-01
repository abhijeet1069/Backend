package com.demo.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaRelationshipsApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringJpaRelationshipsApplication.class, args);
	}

}


/**
 curl --request GET \
 --url http://localhost:8080/employees/1
{
    "department": {
        "id": 1,
        "name": "IT"
    },
    "id": 1,
    "name": "Alice"
}

**/