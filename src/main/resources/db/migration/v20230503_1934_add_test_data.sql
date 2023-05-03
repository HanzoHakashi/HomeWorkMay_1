INSERT INTO usr (first_name, last_name, email, password, address)
VALUES ('Гатс', 'Берсерк', 'berserk@gmail.com', 'qwe', 'MidLand 23');
INSERT INTO categories (name, description)
VALUES ('Электроника', 'Гаджеты и аксессуары'),
('Одежда', 'Бархатные тяги'),
('Дом','Домашние принадлежности и мебель');

INSERT INTO products (name, image, quantity, description, price,category_id)
VALUES ('iPhone 12', 'Путь к картинке', 100, 'Яблоко', 999.99,1),
('Samsung Galaxy S21', 'Путь к картинке', 200, 'Самсанг', 799.99,1),
('Nike Air Max 270 React', 'Бархатные тяги кефтеме', 50, 'Stylish and comfortable sneakers', 149.99,2);