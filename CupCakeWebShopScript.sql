DROP TABLE IF EXISTS orderline;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS bottoms;
DROP TABLE IF EXISTS toppings;

/*CREATE TABLE users(
user_id INT NOT NULL AUTO_INCREMENT,
username VARCHAR(64) NOT NULL UNIQUE,
password VARCHAR(64) NOT NULL,
balance DOUBLE(16,2) DEFAULT 0,
role VARCHAR(64) NOT NULL DEFAULT 'Customer',
PRIMARY KEY (user_id)
);*/

CREATE TABLE orders(
id INT(16) NOT NULL AUTO_INCREMENT,
user_id INT(16),
date DATETIME DEFAULT CURRENT_TIMESTAMP ,
PRIMARY KEY (id),
FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE orderline(
id INT(16) NOT NULL AUTO_INCREMENT,
topping_id INT(16),
bottom_id INT(16),
order_id INT(16),
price INT(16),
amount INT(16),
PRIMARY KEY (id),
FOREIGN KEY (topping_id) REFERENCES toppings(id),
FOREIGN KEY (bottom_id) REFERENCES bottoms(id),
FOREIGN KEY (order_id) REFERENCES orders(id)
);

CREATE TABLE bottoms (
id INT(16) NOT NULL auto_increment,
bottom VARCHAR(64),
price DOUBLE(16,2),
PRIMARY KEY (id)
);

INSERT INTO bottoms (bottom, price) VALUES ('Chocolate', 5.00);
INSERT INTO bottoms (bottom, price) VALUES ('Vanilla', 5.00);
INSERT INTO bottoms (bottom, price) VALUES ('Nutmeg', 5.00);
INSERT INTO bottoms (bottom, price) VALUES ('Pistacio', 6.00);
INSERT INTO bottoms (bottom, price) VALUES ('Almond', 7.00);

CREATE TABLE toppings (
id INT(16) NOT NULL auto_increment,
topping VARCHAR(64),
price DOUBLE(16,2),
PRIMARY KEY (id)
);

INSERT INTO toppings (topping, price) VALUES ('Chocolate',5.00);
INSERT INTO toppings (topping, price) VALUES ('Blueberry',5.00);
INSERT INTO toppings (topping, price) VALUES ('Rasberry',5.00);
INSERT INTO toppings (topping, price) VALUES ('Crispy',6.00);
INSERT INTO toppings (topping, price) VALUES ('Strawberry',6.00);
INSERT INTO toppings (topping, price) VALUES ('Rum/Raisin',7.00);
INSERT INTO toppings (topping, price) VALUES ('Orange',8.00);
INSERT INTO toppings (topping, price) VALUES ('Lemon',8.00);
INSERT INTO toppings (topping, price) VALUES ('Blue Cheese',9.00);

COMMIT;