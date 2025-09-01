CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       full_name VARCHAR(150)
);

insert into users (email, password, full_name) values ('acengSugar@gmail.com', '$2a$10$e/pZ4xeTZz9C3GG5oz9lquIm7TPHGqlIkye22mlz0vmvAFTT3dQoO', 'Aceng Kemoceng')
