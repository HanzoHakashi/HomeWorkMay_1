CREATE TABLE product_feedback (
  id BIGSERIAL PRIMARY KEY,
  product_id BIGSERIAL NOT NULL,
  comment VARCHAR(255) ,
  FOREIGN KEY (product_id) REFERENCES products (id)
);
