CREATE TABLE products
(
    id bigserial NOT NULL CONSTRAINT products_pkey PRIMARY KEY,
    name varchar(255),
    image varchar(255),
    quantity integer,
    description varchar(255),
    price double precision
)


