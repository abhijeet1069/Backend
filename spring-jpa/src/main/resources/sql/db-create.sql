CREATE TABLE employee (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INTEGER NOT NULL
);

--creating user for
create user satyam_spring with password 'satyamx';
grant all privileges on database satyam to satyam_spring;

-- 1. Give schema access
GRANT USAGE ON SCHEMA public TO satyam_spring;

-- 2. Give read access to ALL current tables (employee, department, etc.)
GRANT SELECT ON ALL TABLES IN SCHEMA public TO satyam_spring;

-- 3. Give write/modify access if Spring Boot needs to insert/update
GRANT INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO satyam_spring;

-- 4. Give sequence access for ID generation
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO satyam_spring;

-- check users for db satyam
SELECT
    r.rolname AS role_name,
    d.datname AS database_name,
    has_database_privilege(r.oid, d.oid, 'CONNECT') AS can_connect,
    has_database_privilege(r.oid, d.oid, 'CREATE') AS can_create,
    has_database_privilege(r.oid, d.oid, 'TEMPORARY') AS can_create_temp
FROM
    pg_roles r,
    pg_database d
WHERE
    d.datname = 'satyam'
ORDER BY
    role_name;