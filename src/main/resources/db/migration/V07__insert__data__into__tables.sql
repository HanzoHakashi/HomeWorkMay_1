INSERT INTO categories (name, description)
VALUES ('Электроника', 'Гаджеты и аксессуары'),
       ('Одежда', 'Бархатные тяги'),
       ('Дом', 'Домашние принадлежности и мебель');


INSERT INTO products (name, image, description, price, category_id)
SELECT 'iPhone 12', 'Путь к картинке', 'Яблоко', 999.99, c.id
FROM categories c
WHERE c.name = 'Электроника';

INSERT INTO products (name, image, description, price, category_id)
SELECT 'Samsung Galaxy S21', 'Путь к картинке', 'Самсанг', 799.99, c.id
FROM categories c
WHERE c.name = 'Электроника';

INSERT INTO products (name, image, description, price, category_id)
SELECT 'Nike Air Max 270 React', 'Бархатные тяги кефтеме', 'Stylish and comfortable sneakers', 149.99, c.id
FROM categories c
WHERE c.name = 'Одежда';


INSERT INTO product_feedback (product_id, comment)
VALUES (1, 'Great phone, love the features!'),
       (2, 'Good value for the price.'),
       (3, 'These sneakers are so stylish and comfortable.');
