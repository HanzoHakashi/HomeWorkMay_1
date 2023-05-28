INSERT INTO categories (name, description)
VALUES ('Электроника', 'Гаджеты и аксессуары'),
       ('Одежда', 'Бархатные тяги'),
       ('Дом', 'Домашние принадлежности и мебель');


INSERT INTO products (name, image, description, price, category_id)
SELECT 'PlayStation_5', 'PS5.jpg', 'Sony', 999.99, c.id
FROM categories c
WHERE c.name = 'Электроника';

INSERT INTO products (name, image, description, price, category_id)
SELECT 'S_23', 'S23.jpg', 'Samsung', 799.99, c.id
FROM categories c
WHERE c.name = 'Электроника';

INSERT INTO products (name, image, description, price, category_id)
SELECT 'Switch', 'ns1-1.jpg', 'Nintendo', 149.99, c.id
FROM categories c
WHERE c.name = 'Электроника';


INSERT INTO product_feedback (product_id, comment)
VALUES (1, 'Great phone, love the features!'),
       (2, 'Good value for the price.'),
       (3, 'These sneakers are so stylish and comfortable.');
