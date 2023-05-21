INSERT INTO usr (first_name, last_name, email, password, address,username)
VALUES ('Гатс', 'Берсерк', 'berserk@gmail.com', 'qwe', 'MidLand 23','BlackSwordsman_21'),
('Луффи', 'Монкей Д', 'mugivara@gmail.com', 'gomu', 'EastBlue 23','KingOfPirate'),
('Зоро', 'Ророноа', 'santoryu@gmail.com', 'sanzensekai', 'Unknown ','Zoro_221');
INSERT INTO categories (name, description)
VALUES ('Электроника', 'Гаджеты и аксессуары'),
('Одежда', 'Бархатные тяги'),
('Дом','Домашние принадлежности и мебель');

INSERT INTO products (name, image, description, price,category_id)
VALUES ('iPhone 12', 'Путь к картинке',  'Яблоко', 999.99,1),
('Samsung Galaxy S21', 'Путь к картинке',  'Самсанг', 799.99,1),
('Nike Air Max 270 React', 'Бархатные тяги кефтеме', 'Stylish and comfortable sneakers', 149.99,2);



