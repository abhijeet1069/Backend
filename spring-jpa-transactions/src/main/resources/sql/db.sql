CREATE TABLE account (
                         id BIGSERIAL PRIMARY KEY,
                         owner VARCHAR(100) NOT NULL,
                         balance DECIMAL(10,2) NOT NULL
);

INSERT INTO account(owner, balance)
VALUES
    ('Alice', 1000),
    ('Bob', 500);