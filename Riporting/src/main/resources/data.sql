INSERT INTO product (id, sku, name, price) VALUES (1, 'keyboard', 'Keyboard', 7.99);
INSERT INTO product (id, sku, name, price) VALUES (2, 'tv', 'Television', 351.96);
INSERT INTO product (id, sku, name, price) VALUES (3, 'shirt', 'Shirt', 3.57);
INSERT INTO product (id, sku, name, price) VALUES (4, 'bed', 'Bed', 131.00);
INSERT INTO product (id, sku, name, price) VALUES (5, 'cell-phone', 'Cell Phone', 1000.00);
INSERT INTO product (id, sku, name, price) VALUES (6, 'spoon', 'Spoon', 1.00);

INSERT INTO customer (id, name, birthdate) VALUES (1, 'John Doe', '1960-10-30');
INSERT INTO customer (id, name, birthdate) VALUES (2, 'Pepito Pérez', '1954-07-15');
INSERT INTO customer (id, name, birthdate) VALUES (3, 'Cosme Fulanito', '1956-05-12');

INSERT INTO address (id, street, postal_code) VALUES (1, 'La Habana 4310', '1000');
INSERT INTO address (id, street, postal_code) VALUES (2, '10 rue Henri Poincaré', '13014');
INSERT INTO address (id, street, postal_code) VALUES (3, 'Calle Falsa 123', '01102');

INSERT INTO email_address (id, customer_id, address) VALUES (1, 1, 'john.doe@gmail.com');
INSERT INTO email_address (id, customer_id, address) VALUES (2, 1, 'john.doe@hotmail.com');
INSERT INTO email_address (id, customer_id, address) VALUES (3, 2, 'pepito@perez.com');
INSERT INTO email_address (id, customer_id, address) VALUES (4, 3, 'cosme@fulanito.com');

INSERT INTO purchase_order (id, customer_id, order_date) VALUES (1, 2, '2018-01-04');
INSERT INTO purchase_order (id, customer_id, order_date) VALUES (2, 1, '2018-02-13');
INSERT INTO purchase_order (id, customer_id, order_date) VALUES (3, 2, '2018-02-25');

INSERT INTO item (id, order_id, product_id, quantity, total) VALUES (1, 1, 1, 10, 79.90);
INSERT INTO item (id, order_id, product_id, quantity, total) VALUES (2, 1, 2, 2, 703.92);
INSERT INTO item (id, order_id, product_id, quantity, total) VALUES (3, 1, 3, 7, 24.99);
INSERT INTO item (id, order_id, product_id, quantity, total) VALUES (4, 2, 4, 2, 262.00);
INSERT INTO item (id, order_id, product_id, quantity, total) VALUES (5, 2, 5, 15, 15000.00);
INSERT INTO item (id, order_id, product_id, quantity, total) VALUES (6, 3, 1, 7, 55.93);
INSERT INTO item (id, order_id, product_id, quantity, total) VALUES (7, 3, 6, 18, 18.00);