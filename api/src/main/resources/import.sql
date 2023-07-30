INSERT INTO tb_user (name, email, password, role) VALUES ('Ed', 'ed@gmail.com', 'senha123', 'ADMIN');
INSERT INTO tb_user (name, email, password, role) VALUES ('Frankem', 'frankem@gmail.com', 'senha123', 'USER');
INSERT INTO tb_user (name, email, password, role) VALUES ('Gabriel', 'gabriel@gmail.com', 'senha123', 'USER');

INSERT INTO tb_district (name, delivery_price) VALUES ('Pau Amarelo', 3.0);
INSERT INTO tb_district (name, delivery_price) VALUES ('Beira Mar', 5.0);
INSERT INTO tb_district (name, delivery_price) VALUES ('Conceição', 4.0);

INSERT INTO tb_address (name, street, number, complement, district_id, user_id) VALUES ('Casa', 'Rua Arábia Saudita', '22A', null, 1, 1);
INSERT INTO tb_address (name, street, number, complement, district_id, user_id) VALUES ('Casa da Namorada', 'Rua Cavaleiro', '37', 'Próximo da Emório Karla', 2, 2);
INSERT INTO tb_address (name, street, number, complement, district_id, user_id) VALUES ('Casa', 'Rua Edson Nieling Lundgren', '10', 'Próximo da Panificadora Praia da Conceição', 3, 3);


INSERT INTO tb_product_category (name) VALUES ('Salgados');
INSERT INTO tb_product_category (name) VALUES ('Gelados');
INSERT INTO tb_product_category (name) VALUES ('Pasteis');
INSERT INTO tb_product_category (name) VALUES ('Hamburgueres');

INSERT INTO tb_ingredient (name, description, price, stock) VALUES ('Morango', '', 0.0, 10);
INSERT INTO tb_ingredient (name, description, price, stock) VALUES ('Banana', '', 0.0, 10);
INSERT INTO tb_ingredient (name, description, price, stock) VALUES ('Uva', '', 0.0, 20);
INSERT INTO tb_ingredient (name, description, price, stock) VALUES ('Queijo', '', 0.0, 22);
INSERT INTO tb_ingredient (name, description, price, stock) VALUES ('Calabresa', '', 0.0, 30);

INSERT INTO tb_product (name, image_url, price, product_category_id) VALUES ('Açai', '', 14.0, 1);
INSERT INTO tb_product (name, image_url, price, product_category_id) VALUES ('Pastel Misto', '', 5.0, 2);
INSERT INTO tb_product (name, image_url, price, product_category_id) VALUES ('Hamburguer Amor', '', 22.0, 3);

INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (1, 1);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (1, 2);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (1, 3);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (2, 4);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (2, 5);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (3, 4);

INSERT INTO tb_option (name, maximum_amount, required, repetitious) VALUES ('Escolha uma Opção', 1, true, false);
INSERT INTO tb_option (name, maximum_amount, required, repetitious) VALUES ('Acréscimos', 5, false, true);

INSERT INTO tb_options_ingredients (option_id, ingredient_id) VALUES (1, 1);
INSERT INTO tb_options_ingredients (option_id, ingredient_id) VALUES (2, 1);
INSERT INTO tb_options_ingredients (option_id, ingredient_id) VALUES (1, 2);
INSERT INTO tb_options_ingredients (option_id, ingredient_id) VALUES (2, 2);
INSERT INTO tb_options_ingredients (option_id, ingredient_id) VALUES (1, 3);
INSERT INTO tb_options_ingredients (option_id, ingredient_id) VALUES (2, 3);
INSERT INTO tb_options_ingredients (option_id, ingredient_id) VALUES (1, 4);
INSERT INTO tb_options_ingredients (option_id, ingredient_id) VALUES (2, 4);
INSERT INTO tb_options_ingredients (option_id, ingredient_id) VALUES (1, 5);
INSERT INTO tb_options_ingredients (option_id, ingredient_id) VALUES (2, 5);