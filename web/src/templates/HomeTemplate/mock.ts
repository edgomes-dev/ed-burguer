import { ListItemProps } from '@/components/ListItem';
import { IconType } from 'react-icons';

import {
  FaHamburger as IconHamburger,
  FaIceCream as IconIceCream,
  FaPizzaSlice as IconPizza,
  FaArchive,
  FaAngry
} from 'react-icons/fa';

export const itemsMock: ListItemProps[] = [
  {
    text: 'Hambuger Tradicional',
    img: '/img/hamburger-tradicional.jpg',
    link: '/product/hamburger-tradicional',
    price: 10.0,
    description: 'pão, carne artesanal, '
  },
  {
    text: 'Hambuger Salada',
    img: '/img/hamburger-salada.jpg',
    link: '/product/hamburger-salada',
    price: 8.0,
    description: 'pão, carne artesanal, alface, tomate, cebola crua ou na chapa'
  }
];

export type categoryItemType = {
  icon: IconType;
  text: string;
};

export const categoryMock: categoryItemType[] = [
  {
    icon: FaArchive,
    text: 'salgados'
  },
  {
    icon: IconIceCream,
    text: 'gelados'
  },
  {
    icon: FaAngry,
    text: 'pasteis'
  },
  {
    icon: IconPizza,
    text: 'Pizzas'
  },
  {
    icon: IconHamburger,
    text: 'hamburgueres'
  }
];
