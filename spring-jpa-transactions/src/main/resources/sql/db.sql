CREATE TABLE account (
                         id BIGSERIAL PRIMARY KEY,
                         owner VARCHAR(100) NOT NULL,
                         balance DECIMAL(10,2) NOT NULL
);

INSERT INTO account(owner, balance)
VALUES
    ('Alice', 1000),
    ('Bob', 500);


GRANT ALL ON ALL TABLES IN SCHEMA public TO satyam_spring;
GRANT ALL ON ALL SEQUENCES IN SCHEMA public TO satyam_spring;