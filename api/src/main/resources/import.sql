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
INSERT INTO tb_product_category (name, image_url) VALUES ('Hambúrguer', '04-08-2023-17-22-21hamburguer-icon.svg');
INSERT INTO tb_product_category (name, image_url) VALUES ('Açai', '04-08-2023-17-22-46acai-icon.svg');
INSERT INTO tb_product_category (name, image_url) VALUES ('Bebidas', '04-08-2023-17-23-02bebidas-icon.svg');

INSERT INTO tb_ingredient (name, description, price, repetitions) VALUES ('Pão HotDog', null, null, null);
INSERT INTO tb_ingredient (name, description, price, repetitions) VALUES ('Salsicha', null, 2.50, null);
INSERT INTO tb_ingredient (name, description, price, repetitions) VALUES ('Mussarela', null, 2, null);
INSERT INTO tb_ingredient (name, description, price, repetitions) VALUES ('Milho e Ervilha', null, null, null);
INSERT INTO tb_ingredient (name, description, price, repetitions) VALUES ('Vinagrete', null, 2.50, null);
INSERT INTO tb_ingredient (name, description, price, repetitions) VALUES ('Batata palha', null, null, null);
INSERT INTO tb_ingredient (name, description, price, repetitions) VALUES ('Purê de Batata', null, 3, null);
INSERT INTO tb_ingredient (name, description, price, repetitions) VALUES ('Maionese', null, null, null);
INSERT INTO tb_ingredient (name, description, price, repetitions) VALUES ('Catchup', null, null, null);
INSERT INTO tb_ingredient (name, description, price, repetitions) VALUES ('Mostarda', null, null, null);
INSERT INTO tb_ingredient (name, description, price, repetitions) VALUES ('Frango', 'Desfiado', 5, null);
INSERT INTO tb_ingredient (name, description, price, repetitions) VALUES ('Bacon', null, 6, null);
INSERT INTO tb_ingredient (name, description, price, repetitions) VALUES ('Catupiry', null, 4, null);
INSERT INTO tb_ingredient (name, description, price, repetitions) VALUES ('Ovo', 'Frito', 2.50, null);
INSERT INTO tb_ingredient (name, description, price, repetitions) VALUES ('Ovo de Codorna', null, 4, null);
INSERT INTO tb_ingredient (name, description, price, repetitions) VALUES ('Uva Passa', null, 2.50, null);
INSERT INTO tb_ingredient (name, description, price, repetitions) VALUES ('Cheddar', null, 4, null);
INSERT INTO tb_ingredient (name, description, price, repetitions) VALUES ('Pão de Hambúrguer', null, null, null);
INSERT INTO tb_ingredient (name, description, price, repetitions) VALUES ('Hambúrguer', null, null, null);
INSERT INTO tb_ingredient (name, description, price, repetitions) VALUES ('Presunto', null, 2.50, null);
INSERT INTO tb_ingredient (name, description, price, repetitions) VALUES ('Maionese Caseira', null, null, null);
INSERT INTO tb_ingredient (name, description, price, repetitions) VALUES ('Alface e Tomate', null, null, null);
INSERT INTO tb_ingredient (name, description, price, repetitions) VALUES ('File de frango', null, null, null);

INSERT INTO tb_product (name, image_url, description, price, product_category_id) VALUES ('Cachorro quente simples', '02-08-2023-22-03-18hotdog-simples-min.jpg', 'Pão, salsicha, mussarela, milho, ervilha, batata palha, vinagrete', 5.99, 1);
INSERT INTO tb_product (name, image_url, description, price, product_category_id) VALUES ('Cachorro quente Amoroso', '02-08-2023-22-06-44hotdog-amoroso-min.jpg', 'Pão, purê, salsicha, maionese, catchup, mostarda, batata palha, vinagrete', 16, 1);
INSERT INTO tb_product (name, image_url, description, price, product_category_id) VALUES ('Cachorro quente Caprichoso', '02-08-2023-22-06-10hotdog-caprichoso-min.jpg', 'Pão, Salsicha, Purê de batata, Vinagrete, Milho, Ervilha, Frango desfiado, Bacon, Catupiry, Maionese, Ketchup, Mostarda e batata palha', 29, 1);
INSERT INTO tb_product (name, image_url, description, price, product_category_id) VALUES ('Hambúrguer Simples', '04-08-2023-17-26-51hamburguer-simples.jpg', 'Pão, hambúrguer de carne, presunto, mussarela, maionese caseira, alface e tomate.', 10, 2);
INSERT INTO tb_product (name, image_url, description, price, product_category_id) VALUES ('Hambúrguer Amoroso', '04-08-2023-17-27-10hamburguer-amoroso.jpg', 'Pão, alface, tomate, hambúrguer de carne, bacon, presunto, mussarela e maionese caseira.', 18, 2);
INSERT INTO tb_product (name, image_url, description, price, product_category_id) VALUES ('Hambúrguer Caprichoso', '04-08-2023-17-27-37hamburguer-caprichoso.jpg', 'Pão, hambúrguer de carne, alface, tomate, filé de frango, presunto, mussarela e maionese caseira.', 25, 2);
INSERT INTO tb_product (name, image_url, description, price, product_category_id) VALUES ('Coca Cola (2 Litros)', '04-08-2023-17-30-03coca-cola-2L.jpeg', '', 15, 4);
INSERT INTO tb_product (name, image_url, description, price, product_category_id) VALUES ('Coca Cola (350ml)', '04-08-2023-17-30-30coca-cola-350ml.jpeg', 'COCA COLA LATA', 6, 4);
INSERT INTO tb_product (name, image_url, description, price, product_category_id) VALUES ('Coca Cola (600ml)', '04-08-2023-17-30-50coca-cola-600ml.jpeg', '', 8, 4);
INSERT INTO tb_product (name, image_url, description, price, product_category_id) VALUES ('Fanta Laranja (2 Litros)', '04-08-2023-17-31-11fanta-laranja-2l.jpeg', '', 13, 4);
INSERT INTO tb_product (name, image_url, description, price, product_category_id) VALUES ('Fanta Laranja (350ml)', '04-08-2023-17-31-29fanta-laranja-350ml.jpeg', '', 6, 4);
INSERT INTO tb_product (name, image_url, description, price, product_category_id) VALUES ('Fanta Uva (350ml)', '04-08-2023-17-31-45fanta-uva-350ml.jpeg', '', 6, 4);
INSERT INTO tb_product (name, image_url, description, price, product_category_id) VALUES ('Guaraná (350ml)', '04-08-2023-17-32-01guarana-350ml.jpeg', '', 6, 4);
INSERT INTO tb_product (name, image_url, description, price, product_category_id) VALUES ('H2O (500ml)', '04-08-2023-17-32-20h2o-500ml.jpeg', '', 6, 4);
INSERT INTO tb_product (name, image_url, description, price, product_category_id) VALUES ('Água com Gás (500ml)', '04-08-2023-17-32-38agua-500ml.jpeg', '', 4.50, 4);
INSERT INTO tb_product (name, image_url, description, price, product_category_id) VALUES ('Água sem Gás (500ml)', '04-08-2023-17-32-38agua-500ml.jpeg', '', 3.50, 4);


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

INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (4, 18);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (4, 19);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (4, 20);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (4, 3);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (4, 21);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (4, 22);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (5, 18);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (5, 19);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (5, 12);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (5, 20);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (5, 3);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (5, 21);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (5, 22);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (6, 18);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (6, 19);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (6, 12);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (6, 23);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (6, 20);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (6, 3);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (6, 21);
INSERT INTO tb_products_ingredients (product_id, ingredient_id) VALUES (6, 22);

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