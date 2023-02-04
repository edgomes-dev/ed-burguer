type product = {
  title: string;
  image: string;
  price: number;
};

export const productListMock: product[] = [
  {
    title: "Hamburguer Amoroso",
    image: "/images/hamburguer-amoroso.jpg",
    price: 15.0,
  },
  {
    title: "Hamburguer Estufado",
    image: "/images/hamburguer-estufado.jpg",
    price: 17.4,
  },
  {
    title: "Hamburguer Simples",
    image: "/images/hamburguer-simples.jpg",
    price: 8.25,
  },
];
