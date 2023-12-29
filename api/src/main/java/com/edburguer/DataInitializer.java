package com.edburguer;

import com.edburguer.dto.*;
import com.edburguer.dto.initDb.OrderOptionsInitDbDto;
import com.edburguer.dto.initDb.OrdersInitDbDto;
import com.edburguer.dto.initDb.ProductCategoryInitDbDto;
import com.edburguer.dto.initDb.ProductOrdersInitDbDto;
import com.edburguer.dto.request.SignUpRequest;
import com.edburguer.entity.ProductCategory;
import com.edburguer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer {
    @Autowired
    private UserService userService;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private OptionService optionService;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrdersService ordersService;

    @PostConstruct
    public void initData() {
        userService.saveAuth(new SignUpRequest("Ed", "ed@gmail.com", "81911112222", "senha123"));
        userService.saveAuth(new SignUpRequest("Mikaelli", "mikaelli@gmail.com", "81911112222", "senha123"));
        userService.saveAuth(new SignUpRequest("Cristian", "cristian@gmail.com", "81911112222", "senha123"));
        userService.saveAuth(new SignUpRequest("Frankem", "frankem@gmail.com", "81911112222", "senha123"));
        userService.saveAuth(new SignUpRequest("Gabriel", "gabriel@gmail.com", "81911112222", "senha123"));
        userService.saveAuth(new SignUpRequest("Adriana", "adriana@gmail.com", "81911112222", "senha123"));
        userService.saveAuth(new SignUpRequest("Maria", "maria@gmail.com", "81911112222", "senha123"));
        userService.saveAuth(new SignUpRequest("Pedro", "pedro@gmail.com", "81911112222", "senha123"));
        userService.saveAuth(new SignUpRequest("Paulo", "paulo@gmail.com", "81911112222", "senha123"));
        userService.saveAuth(new SignUpRequest("Tainâ", "taina@gmail.com", "81911112222", "senha123"));
        userService.saveAuth(new SignUpRequest("Mario", "mario@gmail.com", "81911112222", "senha123"));
        userService.saveAuth(new SignUpRequest("Mirelly", "mirelly@gmail.com", "81911112222", "senha123"));
        userService.saveAuth(new SignUpRequest("Rosineide", "rosineide@gmail.com", "81911112222", "senha123"));
        userService.saveAuth(new SignUpRequest("Micael", "micael@gmail.com", "81911112222", "senha123"));
        userService.saveAuth(new SignUpRequest("Gleiciane", "gleiciane@gmail.com", "81911112222", "senha123"));
        userService.saveAuth(new SignUpRequest("Aline", "aline@gmail.com", "81911112222", "senha123"));
        userService.saveAuth(new SignUpRequest("Andre", "andre@gmail.com", "81911112222", "senha123"));
        userService.saveAuth(new SignUpRequest("Julio", "julio@gmail.com", "81911112222", "senha123"));
        userService.saveAuth(new SignUpRequest("Roberta", "roberta@gmail.com", "81911112222", "senha123"));
        userService.saveAuth(new SignUpRequest("Juarez", "juarez@gmail.com", "81911112222", "senha123"));

        districtService.create(new DistrictDto(null, "Pau Amarelo", 3.0));
        districtService.create(new DistrictDto(null, "Beira Mar", 5.0));
        districtService.create(new DistrictDto(null, "Conceição", 4.0));

        addressService.create(new AddressDto(null, "Casa", "Rua Severino Bezerra Ferreira", "10A", null, 1L, 1L));
        addressService.create(new AddressDto(null, "Casa", "Rua Brecho Fernandes Paes", "41", null, 1L, 2L));
        addressService.create(new AddressDto(null, "Casa", "Rua República Árabe Unida", "17", null, 1L, 3L));
        addressService.create(new AddressDto(null, "Casa da Namorada", "Rua Paraguai", "23", null, 1L, 4L));
        addressService.create(new AddressDto(null, "Home", "Rua Vinã Del Mar", "5", null, 1L, 5L));
        addressService.create(new AddressDto(null, "Casa", "Rua Riviera", "39", null, 1L, 6L));
        addressService.create(new AddressDto(null, "Trabalho", "Rua Floresta", "3", null, 2L, 7L));
        addressService.create(new AddressDto(null, "Doce Lar", "Rua João Alfredo", "51", null, 2L, 8L));
        addressService.create(new AddressDto(null, "Office", "Rua Lagoa dos Gatos", "22A", null, 2L, 9L));
        addressService.create(new AddressDto(null, "Casa", "Rua Poeta João Neves", "36", null, 2L, 10L));
        addressService.create(new AddressDto(null, "Casa de Mãe", "Rua Feira Nova", "18B", null, 2L, 11L));
        addressService.create(new AddressDto(null, "Casa", "Rua Glória do Goitá", "11", null, 2L, 12L));
        addressService.create(new AddressDto(null, "Casa", "Rua Pombos", "91", null, 3L, 13L));
        addressService.create(new AddressDto(null, "Casa", "Rua Manoel Tomás da Cunha",  "311", null, 3L, 14L));
        addressService.create(new AddressDto(null, "Casa", "Rua Francisco Monteiro", "20A", null, 3L, 15L));
        addressService.create(new AddressDto(null, "Casa", "Rua Atalaia", "15B", null, 3L, 16L));
        addressService.create(new AddressDto(null, "Casa", "Rua Sudão", "2", null, 3L, 17L));
        addressService.create(new AddressDto(null, "Casa", "Rua João Sergio de Farias", "46", null, 3L, 18L));
        addressService.create(new AddressDto(null, "Casa", "Rua Doutor Aluizo Lira de Souza", "47", null, 3L, 19L));
        addressService.create(new AddressDto(null, "Casa", "Rua Iuguslavia", "63", null, 3L, 20L));

        productCategoryService.create(new ProductCategoryInitDbDto(null, "Cachorro Quente", "02-08-2023-22-08-16hot-dog-svgrepo.svg"));
        productCategoryService.create(new ProductCategoryInitDbDto(null, "Hambúrguer", "04-08-2023-17-22-21hamburguer-icon.svg"));
        productCategoryService.create(new ProductCategoryInitDbDto(null, "Pizza", "30-11-2023-21-35-02pizza.svg"));
        productCategoryService.create(new ProductCategoryInitDbDto(null, "Porções", "30-11-2023-21-35-15portion.svg"));
        productCategoryService.create(new ProductCategoryInitDbDto(null, "Salgados", "30-11-2023-21-35-32salty.svg"));
        productCategoryService.create(new ProductCategoryInitDbDto(null, "Açai", "04-08-2023-17-22-46acai-icon.svg"));
        productCategoryService.create(new ProductCategoryInitDbDto(null, "Bebidas", "04-08-2023-17-23-02bebidas-icon.svg"));

        ingredientService.create(new IngredientDto(null, "Pão HotDog", null, null,  1));
        ingredientService.create(new IngredientDto(null, "Salsicha", null, 2.50,  3));
        ingredientService.create(new IngredientDto(null, "Mussarela", null, 2.50,  1));
        ingredientService.create(new IngredientDto(null, "Milho e Ervilha", null, null,  1));
        ingredientService.create(new IngredientDto(null, "Vinagrete", null, 2.50,  1));
        ingredientService.create(new IngredientDto(null, "Batata palha", null, null,  1));
        ingredientService.create(new IngredientDto(null, "Purê de Batata", null, 3.00,  1));
        ingredientService.create(new IngredientDto(null, "Maionese", null, null,  1));
        ingredientService.create(new IngredientDto(null, "Catchup", null, null,  1));
        ingredientService.create(new IngredientDto(null, "Mostarda", null, null,  1));
        ingredientService.create(new IngredientDto(null, "Frango", "Desfiado", 5.00,  1));
        ingredientService.create(new IngredientDto(null, "Bacon", null, 6.00,  1));
        ingredientService.create(new IngredientDto(null, "Catupiry", null, 4.00,  1));
        ingredientService.create(new IngredientDto(null, "Ovo", "Frito", 2.50,  1));
        ingredientService.create(new IngredientDto(null, "Ovo de Codorna", null, 4.00,  1));
        ingredientService.create(new IngredientDto(null, "Uva Passa", null, 2.50,  1));
        ingredientService.create(new IngredientDto(null, "Cheddar", null, 4.00,  1));
        ingredientService.create(new IngredientDto(null, "Pão de Hambúrguer", null, null,  1));
        ingredientService.create(new IngredientDto(null, "Hambúrguer", null, null,  1));
        ingredientService.create(new IngredientDto(null, "Presunto", null, 2.50,  1));
        ingredientService.create(new IngredientDto(null, "Maionese Caseira", null, null,  1));
        ingredientService.create(new IngredientDto(null, "Alface e Tomate", null, null,  1));
        ingredientService.create(new IngredientDto(null, "File de frango", null, null,  1));
        ingredientService.create(new IngredientDto(null, "Sem Prensar", null, null,  1));
        ingredientService.create(new IngredientDto(null, "Prensado", null, null,  1));
        ingredientService.create(new IngredientDto(null, "Calabresa", null, null,  1));
        ingredientService.create(new IngredientDto(null, "Massa de Pizza", null, null,  1));
        ingredientService.create(new IngredientDto(null, "Molho de Tomate", null, null,  1));
        ingredientService.create(new IngredientDto(null, "Orégano", null, null,  1));
        ingredientService.create(new IngredientDto(null, "Marguerita", null, null,  1));
        ingredientService.create(new IngredientDto(null, "3 Queijos", null, null,  1));
        ingredientService.create(new IngredientDto(null, "Batata Frita", null, null,  1));
        ingredientService.create(new IngredientDto(null, "Onion Rings", null, null,  1));

        optionService.create(new OptionDto(null, "Escolha uma Opção", 1, true, 1L, List.of(24L, 25L)));
        optionService.create(new OptionDto(null, "Acréscimos", 5, false, 1L, List.of(14L, 12L, 13L, 17L, 11L, 4L, 3L, 15L, 7L, 2L, 16L, 5L)));

        productService.create(new ProductDtoInitDB(null, "Cachorro Quente Piloto", "28-11-2023-17-51-01hotdog-piloto.jpg", "Pão, Salsicha, Mussarela, Milho, Ervilha, Batata Palha, Vinagrete", 6.90, 1L, List.of(1L, 2L, 3L, 4L, 5L, 6L)));
        productService.create(new ProductDtoInitDB(null, "Cachorro Quente Caprichoso", "28-11-2023-17-51-30hotdog-caprichoso.jpg", "Pão, purê, salsicha, maionese, catchup, mostarda, batata palha, vinagrete", 9.90, 1L, List.of(1L, 7L, 8L, 9L, 10L, 6L, 5L)));
        productService.create(new ProductDtoInitDB(null, "Cachorro Quente Cuidadoso", "28-11-2023-17-51-48hotdog-cuidadoso.jpg", "Pão, Purê, Milho, Ervilha, Maionese, Salsicha, Batata Palha, Vinagrete", 12.90, 1L, List.of(1L, 7L, 4L, 8L, 2L, 6L, 5L)));
        productService.create(new ProductDtoInitDB(null, "Cachorro Quente Amoroso", "28-11-2023-17-51-59hotdog-amoroso.jpg", "Pao, purê de batata, Salsicha, Vinagrete, Ervilha, Milho, Bacon, Cheddar, Maionese, Catchup, Mostarda e Batata palha", 15.90, 1L, List.of(1L, 7L, 2L, 5L, 4L, 12L, 16L, 8L, 9L, 10L, 6L)));
        productService.create(new ProductDtoInitDB(null, "Cachorro Quente Atencioso", "28-11-2023-17-52-04hotdog-atencioso.jpg", "Pão, Salsicha, Purê, Vinagrete, Milho, Ervilha, Bacon, Catupiry, Maionese, Catchup, Mostarda e Batata palha", 19.90, 1L, List.of(1L, 2L, 7L, 5L, 4L, 12L, 8L, 9L, 10L, 6L)));
        productService.create(new ProductDtoInitDB(null, "Cachorro Quente Verdadeiro", "28-11-2023-17-52-15hotdog-verdadeiro.jpg", "Pão, Salsicha, Purê de batata, Vinagrete, Milho, Ervilha, Frango desfiado, Bacon, Catupiry, Maionese, Ketchup, Mostarda e batata palha", 24.90, 1L, List.of(1L, 2L, 7L, 5L, 4L, 11L, 12L, 13L, 8L, 9L, 10L, 6L)));
        productService.create(new ProductDtoInitDB(null, "Hambúrguer Piloto", "29-11-2023-08-58-01hamburguer-piloto.jpg", "Pão, hambúrguer, presunto, mussarela, maionese caseira, alface e tomate.", 8.90, 2L, List.of(17L, 18L, 19L, 3L, 20L, 21L, 22L)));
        productService.create(new ProductDtoInitDB(null, "Hambúrguer Caprichoso", "29-11-2023-08-58-47hamburguer-caprichoso.jpg", "Pão, alface, tomate, hambúrguer, bacon, presunto, mussarela e maionese caseira.", 11.90, 2L, List.of(17L, 21L, 22L, 18L, 12L, 19L, 3L, 20L)));
        productService.create(new ProductDtoInitDB(null, "Hambúrguer Cuidadoso", "29-11-2023-08-59-04hamburguer-cuidadoso.jpg", "Pão, alface, tomate, hambúrguer, calabresa, presunto, mussarela e maionese caseira.", 14.90, 2L, List.of(17L, 21L, 22L, 18L, 26L, 19L, 3L, 20L)));
        productService.create(new ProductDtoInitDB(null, "Hambúrguer Amoroso", "29-11-2023-08-59-39hamburguer-amoroso.jpg", "Pão, alface, tomate, filé de frango, ovo, bacon, presunto, mussarela e maionese caseira.", 19.90, 2L, List.of(17L, 18L, 21L, 22L, 11L, 14L, 12L, 19L, 3L, 20L)));
        productService.create(new ProductDtoInitDB(null, "Hambúrguer Atencioso", "29-11-2023-09-00-08hamburguer-atencioso.jpg", "Pão, alface, tomate, hambúrguer, ovo, bacon, presunto, mussarela e maionese caseira.", 22.90, 2L, List.of(17L, 21L, 22L, 18L, 14L, 12L, 19L, 3L, 20L)));
        productService.create(new ProductDtoInitDB(null, "Hambúrguer Verdadeiro", "29-11-2023-09-00-20hamburguer-verdadeiro.jpg", "Pão, hambúrguer, alface, tomate, filé de frango, presunto, mussarela e maionese caseira.", 24.90, 2L, List.of(17L, 21L, 22L, 18L, 14L, 12L, 19L, 3L, 20L)));
        productService.create(new ProductDtoInitDB(null, "Pizza de Calabresa", "30-11-2023-21-40-05pizza-pepperoni.jpg", "", 24.90, 3L, List.of(17L, 18L, 21L, 22L, 11L, 19L, 3L)));
        productService.create(new ProductDtoInitDB(null, "Pizza de Presunto", "30-11-2023-21-40-11pizza-ham.jpeg", "", 24.90, 3L, List.of(27L, 28L, 29L, 26L)));
        productService.create(new ProductDtoInitDB(null, "Pizza de Frango", "30-11-2023-21-40-13pizza-chicken.jpg", "", 24.90, 3L, List.of(27L, 28L, 29L, 19L)));
        productService.create(new ProductDtoInitDB(null, "Pizza de Mussarela", "30-11-2023-21-40-21pizza-mozzarella.jpg", "", 24.90, 3L, List.of(27L, 28L, 29L, 11L)));
        productService.create(new ProductDtoInitDB(null, "Pizza de Marguerita", "30-11-2023-21-41-31pizza-margherita.jpg", "", 24.90, 3L, List.of(27L, 28L, 29L, 3L)));
        productService.create(new ProductDtoInitDB(null, "Pizza de 3 Queijos", "30-11-2023-21-41-45pizza-cheese.jpeg", "", 24.90, 3L, List.of(27L, 28L, 29L, 30L)));
        productService.create(new ProductDtoInitDB(null, "Batata Frita", "30-11-2023-22-49-05french-fries.jpeg", "", 9.90, 4L, List.of(27L, 27L, 27L, 31L)));
        productService.create(new ProductDtoInitDB(null, "Batata Frita com Bacon e Cheddar", "30-11-2023-22-49-05french-fries-with-cheddar.jpeg", "", 11.90, 4L, List.of(32L)));
        productService.create(new ProductDtoInitDB(null, "Onion Rings", "30-11-2023-22-51-03onion-rings.jpeg", "", 4.90, 4L, List.of(32L, 12L, 16L)));
        productService.create(new ProductDtoInitDB(null, "Coxinha de Frango", "01-12-2023-08-44-20chicken-drumstick.jpeg", "", 4.90, 4L, List.of(33L)));
        productService.create(new ProductDtoInitDB(null, "Coxinha de Frango com Catupry", "01-12-2023-08-44-26coxinha-chicken-catupiry.jpeg", "", 4.90, 4L, List.of(1L)));
        productService.create(new ProductDtoInitDB(null, "Pastel", "01-12-2023-08-44-33pastry.jpeg", "", 4.90, 5L, List.of(1L)));
        productService.create(new ProductDtoInitDB(null, "Enroladinho", "01-12-2023-08-45-01curled.jpeg", "", 4.90, 5L, List.of(1L)));
        productService.create(new ProductDtoInitDB(null, "Empada de Frango", "01-12-2023-08-45-29chicken-pie.jpeg", "", 4.90, 5L, List.of(1L)));
        productService.create(new ProductDtoInitDB(null, "Empada Doce", "01-12-2023-08-45-32sweet-pie.jpeg", "", 4.90, 5L, List.of(1L)));
        productService.create(new ProductDtoInitDB(null, "Açai Simples", "04-08-2023-17-27-52acai-simples.jpg", "", 6.90, 6L, List.of(1L)));
        productService.create(new ProductDtoInitDB(null, "Açai Amoroso", "04-08-2023-17-28-09acai-amoroso.jpg", "", 14.90, 6L, List.of(1L)));
        productService.create(new ProductDtoInitDB(null, "Açai Caprichoso", "04-08-2023-17-28-24acai-caprichoso.jpg", "", 22.90, 6L, List.of(1L)));
        productService.create(new ProductDtoInitDB(null, "Coca Cola (2 Litros)", "04-08-2023-17-30-03coca-cola-2L.jpeg", "", 14.90, 7L, List.of(1L)));
        productService.create(new ProductDtoInitDB(null, "Coca Cola (350ml)", "04-08-2023-17-30-30coca-cola-350ml.jpeg", "COCA COLA LATA", 5.90, 7L, List.of(1L)));
        productService.create(new ProductDtoInitDB(null, "Coca Cola (600ml)", "04-08-2023-17-30-50coca-cola-600ml.jpeg", "", 7.90, 7L, List.of(1L)));
        productService.create(new ProductDtoInitDB(null, "Fanta Laranja (2 Litros)", "04-08-2023-17-31-11fanta-laranja-2l.jpeg", "", 12.90, 7L, List.of(1L)));
        productService.create(new ProductDtoInitDB(null, "Fanta Laranja (350ml)", "04-08-2023-17-31-29fanta-laranja-350ml.jpeg", "", 5.90, 7L, List.of(1L)));
        productService.create(new ProductDtoInitDB(null, "Fanta Uva (350ml)", "04-08-2023-17-31-45fanta-uva-350ml.jpeg", "", 5.90, 7L, List.of(1L)));
        productService.create(new ProductDtoInitDB(null, "Guaraná (350ml)", "04-08-2023-17-32-01guarana-350ml.jpeg", "", 5.90, 7L, List.of(1L)));
        productService.create(new ProductDtoInitDB(null, "H2O (500ml)", "04-08-2023-17-32-20h2o-500ml.jpeg", "", 5.90, 7L, List.of(1L)));
        productService.create(new ProductDtoInitDB(null, "Água com Gás (500ml)", "04-08-2023-17-32-38agua-500ml.jpeg", "", 4.50, 7L, List.of(1L)));
        productService.create(new ProductDtoInitDB(null, "Água sem Gás (500ml)", "04-08-2023-17-32-38agua-500ml.jpeg", "", 3.50, 7L, List.of(1L)));


        ordersService.create(new OrdersInitDbDto(1L, 1L, 4, 1, 2, "00000000000", 26.90, List.of(new ProductOrdersInitDbDto(3L, "isso é um teste", 1, List.of(new OrderOptionsInitDbDto("Escolha uma Opção", List.of(24L)), new OrderOptionsInitDbDto("Adicionais", List.of(12L, 15L)))))));
        ordersService.create(new OrdersInitDbDto(2L, 2L, 4, 1, 2, "00000000000", 43.80, List.of(new ProductOrdersInitDbDto(15L, "isso é um teste", 1, null), new ProductOrdersInitDbDto(31L, "isso é um teste", 1, null))));
        ordersService.create(new OrdersInitDbDto(3L, 3L, 4, 2, 2, "00000000000", 27.90, List.of(new ProductOrdersInitDbDto(30L, "isso é um teste", 1, null))));
        ordersService.create(new OrdersInitDbDto(4L, 4L, 4, 2, 1, "00000000000", 17.80, List.of(new ProductOrdersInitDbDto(7L, "isso é um teste", 1, null), new ProductOrdersInitDbDto(19L, "isso é um teste", 1, null), new ProductOrdersInitDbDto(23L, "isso é um teste", 1, null), new ProductOrdersInitDbDto(24L, "isso é um teste", 1, null), new ProductOrdersInitDbDto(31L, "isso é um teste", 1, null))));
        ordersService.create(new OrdersInitDbDto(5L, 5L, 4, 3, 2, "00000000000", 17.80, List.of(new ProductOrdersInitDbDto(18L, "isso é um teste", 1, null), new ProductOrdersInitDbDto(37L, "isso é um teste", 1, null))));

        ordersService.create(new OrdersInitDbDto(6L, 6L, 3, 3, 2, "00000000000", 27.90, List.of(new ProductOrdersInitDbDto(10L, "isso é um teste", 1, null), new ProductOrdersInitDbDto(12L, "isso é um teste", 1, null))));
        ordersService.create(new OrdersInitDbDto(7L, 7L, 3, 3, 1, "00000000000", 17.80, List.of(new ProductOrdersInitDbDto(21L, "isso é um teste", 1, null), new ProductOrdersInitDbDto(24L, "isso é um teste", 1, null), new ProductOrdersInitDbDto(33L, "isso é um teste", 1, null))));
        ordersService.create(new OrdersInitDbDto(8L, 8L, 3, 2, 2, "00000000000", 17.80, List.of(new ProductOrdersInitDbDto(13L, "isso é um teste", 1, null))));
        ordersService.create(new OrdersInitDbDto(9L, 9L, 3, 1, 2, "00000000000", 17.80, List.of(new ProductOrdersInitDbDto(10L, "isso é um teste", 1, null), new ProductOrdersInitDbDto(27L, "isso é um teste", 1, null))));
        ordersService.create(new OrdersInitDbDto(10L, 10L, 3, 2, 2, "00000000000", 17.80, List.of(new ProductOrdersInitDbDto(22L, "isso é um teste", 1, null), new ProductOrdersInitDbDto(25L, "isso é um teste", 1, null), new ProductOrdersInitDbDto(34L, "isso é um teste", 1, null))));

        ordersService.create(new OrdersInitDbDto(11L, 11L, 2, 3, 1, "00000000000", 27.90, List.of(new ProductOrdersInitDbDto(38L, "isso é um teste", 1, null), new ProductOrdersInitDbDto(39L, "isso é um teste", 1, null), new ProductOrdersInitDbDto(28L, "isso é um teste", 1, null))));
        ordersService.create(new OrdersInitDbDto(12L, 12L, 2, 2, 2, "00000000000", 17.80, List.of(new ProductOrdersInitDbDto(30L, "isso é um teste", 1, null))));
        ordersService.create(new OrdersInitDbDto(13L, 13L, 2, 1, 2, "00000000000", 17.80, List.of(new ProductOrdersInitDbDto(25L, "isso é um teste", 5, null), new ProductOrdersInitDbDto(31L, "isso é um teste", 1, null))));
        ordersService.create(new OrdersInitDbDto(14L, 14L, 2, 3, 2, "00000000000", 17.80, List.of(new ProductOrdersInitDbDto(15L, "isso é um teste", 1, null), new ProductOrdersInitDbDto(36L, "isso é um teste", 1, null))));
        ordersService.create(new OrdersInitDbDto(15L, 15L, 2, 3, 2, "00000000000", 17.80, List.of(new ProductOrdersInitDbDto(26L, "isso é um teste", 1, null), new ProductOrdersInitDbDto(27L, "isso é um teste", 1, null), new ProductOrdersInitDbDto(29L, "isso é um teste", 1, null))));

        ordersService.create(new OrdersInitDbDto(16L, 16L, 1, 3, 2, "00000000000", 27.90, List.of(new ProductOrdersInitDbDto(11L, "isso é um teste", 1, null), new ProductOrdersInitDbDto(12L, "isso é um teste", 1, null))));
        ordersService.create(new OrdersInitDbDto(17L, 17L, 1, 3, 2, "00000000000", 17.80, List.of(new ProductOrdersInitDbDto(19L, "isso é um teste", 2, null), new ProductOrdersInitDbDto(34L, "isso é um teste", 1, null))));
        ordersService.create(new OrdersInitDbDto(18L, 18L, 1, 2, 2, "00000000000", 17.80, List.of(new ProductOrdersInitDbDto(17L, "isso é um teste", 1, null), new ProductOrdersInitDbDto(29L, "isso é um teste", 1, null), new ProductOrdersInitDbDto(31L, "isso é um teste", 1, null), new ProductOrdersInitDbDto(29L, "isso é um teste", 1, null), new ProductOrdersInitDbDto(9L, "isso é um teste", 1, null))));
        ordersService.create(new OrdersInitDbDto(19L, 19L, 1, 2, 2, "00000000000", 17.80, List.of(new ProductOrdersInitDbDto(7L, "isso é um teste", 1, null))));
        ordersService.create(new OrdersInitDbDto(20L, 20L, 1, 1, 1, "00000000000", 17.80, List.of(new ProductOrdersInitDbDto(24L, "isso é um teste", 1, null), new ProductOrdersInitDbDto(20L, "isso é um teste", 1, null), new ProductOrdersInitDbDto(11L, "isso é um teste", 1, null))));
    }
}