CREATE TABLE department (
                            id BIGSERIAL PRIMARY KEY,
                            name VARCHAR(100) NOT NULL
);

CREATE TABLE employee (
                          id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          department_id BIGINT NOT NULL REFERENCES department(id)
);

INSERT INTO department(name)
VALUES
    ('IT'),
    ('HR');

INSERT INTO employee(name, department_id)
VALUES
    ('Alice',1),
    ('Bob',1),
    ('Charlie',2);