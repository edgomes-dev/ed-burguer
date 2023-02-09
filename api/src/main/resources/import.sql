INSERT INTO tb_district (id, name, delivery_price) VALUES (1, 'Pau Amarelo', 3.0);
INSERT INTO tb_district (id, name, delivery_price) VALUES (2, 'Beira Mar', 5.0);
INSERT INTO tb_district (id, name, delivery_price) VALUES (3, 'Conceição', 4.0);

INSERT INTO tb_user (id, name, email, password, administrator) VALUES (1, 'Ed', 'ed@gmail.com', 'senha123', true);
INSERT INTO tb_user (id, name, email, password, administrator) VALUES (2, 'Frankem', 'frankem@gmail.com', 'senha123', false);
INSERT INTO tb_user (id, name, email, password, administrator) VALUES (3, 'Gabriel', 'gabriel@gmail.com', 'senha123', false);

INSERT INTO tb_address (id, name, street, number, complement, district_id, user_id) VALUES (1, 'Casa', 'Rua Arábia Saudita', '22A', null, 1, 1);
INSERT INTO tb_address (id, name, street, number, complement, district_id, user_id) VALUES (2, 'Casa da Namorada', 'Rua Cavaleiro', '37', 'Próximo da Emório Karla', 2, 2);
INSERT INTO tb_address (id, name, street, number, complement, district_id, user_id) VALUES (3, 'Casa', 'Rua Edson Nieling Lundgren', '10', 'Próximo da Panificadora Praia da Conceição', 3, 3);

INSERT INTO tb_product_category (id, name, image_url) VALUES (1, 'Gelados', '');
INSERT INTO tb_product_category (id, name, image_url) VALUES (2, 'Pasteis', '');
INSERT INTO tb_product_category (id, name, image_url) VALUES (3, 'Hamburguers', '');

INSERT INTO tb_product (id, name, image_url, price, product_category_id) VALUES (1, 'Açai', '', 14.0, 1);
INSERT INTO tb_product (id, name, image_url, price, product_category_id) VALUES (2, 'Pastel Misto', '', 5.0, 2);
INSERT INTO tb_product (id, name, image_url, price, product_category_id) VALUES (3, 'Hamburguer Amor', '', 22.0, 3);

INSERT INTO tb_ingredient (id, name, price) VALUES (1, 'Morango', 0.0);
INSERT INTO tb_ingredient (id, name, price) VALUES (2, 'Banana', 0.0);
INSERT INTO tb_ingredient (id, name, price) VALUES (3, 'Uva', 0.0);
INSERT INTO tb_ingredient (id, name, price) VALUES (4, 'Queijo', 0.0);
INSERT INTO tb_ingredient (id, name, price) VALUES (5, 'Calabresa', 0.0);

INSERT INTO tb_ingredient_product (product_id, ingredient_id) VALUES (1, 1);
INSERT INTO tb_ingredient_product (product_id, ingredient_id) VALUES (1, 2);
INSERT INTO tb_ingredient_product (product_id, ingredient_id) VALUES (1, 3);
INSERT INTO tb_ingredient_product (product_id, ingredient_id) VALUES (2, 4);
INSERT INTO tb_ingredient_product (product_id, ingredient_id) VALUES (2, 5);
INSERT INTO tb_ingredient_product (product_id, ingredient_id) VALUES (3, 4);