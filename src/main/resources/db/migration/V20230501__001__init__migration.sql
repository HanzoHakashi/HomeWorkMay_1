

CREATE TABLE  IF NOT EXISTS categories (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255)
);

CREATE TABLE  IF NOT EXISTS products(
    id BIGSERIAL  PRIMARY KEY,
    name varchar(255),
    image varchar(255),
    quantity integer,
    description varchar(255),
    price double precision,
    category_id BIGSERIAL REFERENCES categories(id),
    comments VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS usr (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    username VARCHAR(255)
);

CREATE TABLE  IF NOT EXISTS comments  (
  id BIGSERIAL PRIMARY KEY,
  text VARCHAR(255),
  product_id BIGSERIAL REFERENCES products(id),
  user_id BIGSERIAL REFERENCES usr(id)
);
CREATE TABLE  IF NOT EXISTS orders (
  id BIGSERIAL PRIMARY KEY,
  user_id BIGSERIAL REFERENCES usr(id),
  total_price DECIMAL(10,2) NOT NULL
);

