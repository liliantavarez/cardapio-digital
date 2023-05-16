CREATE TABLE foods
(
    id    SERIAL PRIMARY KEY,
    title TEXT    NOT NULL,
    price DECIMAL(5,2) NOT NULL,
    image TEXT
);