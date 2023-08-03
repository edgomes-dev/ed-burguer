INSERT INTO tb_user (name, email, password, role) VALUES ('Ed', 'ed@gmail.com', 'senha123', 'ADMIN');
INSERT INTO tb_user (name, email, password, role) VALUES ('Frankem', 'frankem@gmail.com', 'senha123', 'USER');
INSERT INTO tb_user (name, email, password, role) VALUES ('Gabriel', 'gabriel@gmail.com', 'senha123', 'USER');

INSERT INTO tb_district (name, delivery_price) VALUES ('Pau Amarelo', 3.0);
INSERT INTO tb_district (name, delivery_price) VALUES ('Beira Mar', 5.0);
INSERT INTO tb_district (name, delivery_price) VALUES ('Conceição', 4.0);

INSERT INTO tb_address (name, street, number, complement, district_id, user_id) VALUES ('Casa', 'Rua Arábia Saudita', '22A', null, 1, 1);
INSERT INTO tb_address (name, street, number, complement, district_id, user_id) VALUES ('Casa da Namorada', 'Rua Cavaleiro', '37', 'Próximo da Emório Karla', 2, 2);
INSERT INTO tb_address (name, street, number, complement, district_id, user_id) VALUES ('Casa', 'Rua Edson Nieling Lundgren', '10', 'Próximo da Panificadora Praia da Conceição', 3, 3);


INSERT INTO tb_product_category (name, image_url) VALUES ('Cachorro Quente', '02-08-2023-22-08-16hot-dog-svgrepo.svg');

INSERT INTO tb_ingredient (name, description, price, stock, repetitions) VALUES ('Pão HotDog', null, null, 50, null);
INSERT INTO tb_ingredient (name, description, price, stock, repetitions) VALUES ('Salsicha', null, 2.50, 50, null);
INSERT INTO tb_ingredient (name, description, price, stock, repetitions) VALUES ('Mussarela', null, 2, 50, null);
INSERT INTO tb_ingredient (name, description, price, stock, repetitions) VALUES ('Milho e Ervilha', null, null, 50, null);
INSERT INTO tb_ingredient (name, description, price, stock, repetitions) VALUES ('Vinagrete', null, 2.50, 50, null);
INSERT INTO tb_ingredient (name, description, price, stock, repetitions) VALUES ('Batata palha', null, null, 50, null);
INSERT INTO tb_ingredient (name, description, price, stock, repetitions) VALUES ('Purê de Batata', null, 3, 50, null);
INSERT INTO tb_ingredient (name, description, price, stock, repetitions) VALUES ('Maionese', null, null, 50, null);
INSERT INTO tb_ingredient (name, description, price, stock, repetitions) VALUES ('Catchup', null, null, 50, null);
INSERT INTO tb_ingredient (name, description, price, stock, repetitions) VALUES ('Mostarda', null, null, 50, null);
INSERT INTO tb_ingredient (name, description, price, stock, repetitions) VALUES ('Frango', 'Desfiado', 5, 50, null);
INSERT INTO tb_ingredient (name, description, price, stock, repetitions) VALUES ('Bacon', null, 6, 50, null);
INSERT INTO tb_ingredient (name, description, price, stock, repetitions) VALUES ('Catupiry', null, 4, 50, null);
INSERT INTO tb_ingredient (name, description, price, stock, repetitions) VALUES ('Ovo', 'Frito', 2.50, 50, null);
INSERT INTO tb_ingredient (name, description, price, stock, repetitions) VALUES ('Ovo de Codorna', null, 4, 50, null);
INSERT INTO tb_ingredient (name, description, price, stock, repetitions) VALUES ('Uva Passa', null, 2.50, 50, null);
INSERT INTO tb_ingredient (name, description, price, stock, repetitions) VALUES ('Cheddar', null, 4, 50, null);

INSERT INTO tb_product (name, image_url, description, price, product_category_id) VALUES ('Cachorro quente simples', '02-08-2023-22-03-18hotdog-simples-min.jpg', 'Pão, salsicha, mussarela, milho, ervilha, batata palha, vinagrete', 5.99, 1);
INSERT INTO tb_product (name, image_url, description, price, product_category_id) VALUES ('Amoroso', '02-08-2023-22-06-44hotdog-amoroso-min.jpg', 'Pão, purê, salsicha, maionese, catchup, mostarda, batata palha, vinagrete', 16, 1);
INSERT INTO tb_product (name, image_url, description, price, product_category_id) VALUES ('Caprichoso', '02-08-2023-22-06-10hotdog-caprichoso-min.jpg', 'Pão, Salsicha, Purê de batata, Vinagrete, Milho, Ervilha, Frango desfiado, Bacon, Catupiry, Maionese, Ketchup, Mostarda e batata palha', 29, 1);

INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (1, 1);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (1, 2);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (1, 3);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (1, 4);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (1, 5);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (1, 6);

INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (2, 1);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (2, 2);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (2, 7);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (2, 8);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (2, 9);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (2, 10);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (2, 5);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (2, 6);

INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (3, 1);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (3, 2);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (3, 7);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (3, 5);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (3, 4);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (3, 11);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (3, 12);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (3, 13);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (3, 8);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (3, 9);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (3, 10);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (3, 6);

INSERT INTO tb_option (name, maximum_amount, required, repetitious, options_required) VALUES ('Escolha uma Opção', 1, true, false, 'Sem Prensar/Prensado');
INSERT INTO tb_option (name, maximum_amount, required, repetitious) VALUES ('Acréscimos', 5, false, true);

INSERT INTO tb_options_ingredients (option_id, ingredient_id) VALUES (2, 14);
INSERT INTO tb_options_ingredients (option_id, ingredient_id) VALUES (2, 12);
INSERT INTO tb_options_ingredients (option_id, ingredient_id) VALUES (2, 13);
INSERT INTO tb_options_ingredients (option_id, ingredient_id) VALUES (2, 17);
INSERT INTO tb_options_ingredients (option_id, ingredient_id) VALUES (2, 11);
INSERT INTO tb_options_ingredients (option_id, ingredient_id) VALUES (2, 4);
INSERT INTO tb_options_ingredients (option_id, ingredient_id) VALUES (2, 3);
INSERT INTO tb_options_ingredients (option_id, ingredient_id) VALUES (2, 15);
INSERT INTO tb_options_ingredients (option_id, ingredient_id) VALUES (2, 7);
INSERT INTO tb_options_ingredients (option_id, ingredient_id) VALUES (2, 2);
INSERT INTO tb_options_ingredients (option_id, ingredient_id) VALUES (2, 16);
INSERT INTO tb_options_ingredients (option_id, ingredient_id) VALUES (2, 5);