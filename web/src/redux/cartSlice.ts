import { createSlice } from '@reduxjs/toolkit';
import { RootState } from './store';

type ProductType = {
  image_url: string;
  name: string;
  quantity: number;
  price: number;
  observartion?: string;
};
const products: ProductType[] = [
  {
    image_url: '/img/02-08-2023-22-03-18hotdog-simples-min.jpg',
    name: 'Cachorro quente simples',
    quantity: 1,
    price: 5.99,
    observartion: 'Sem cebola'
  },
  {
    image_url: '/img/02-08-2023-22-06-44hotdog-amoroso-min.jpg',
    name: 'Cachorro quente Amoroso',
    quantity: 2,
    price: 16
  },
  {
    image_url: '/img/02-08-2023-22-06-10hotdog-caprichoso-min.jpg',
    name: 'Cachorro quente Caprichoso',
    quantity: 1,
    price: 29
  }
];

interface ICart {
  items: ProductType[];
  quantityItems: number;
  totalPrice: number;
}

const initialState: ICart = {
  items: products,
  quantityItems: 3,
  totalPrice: 50.99
};

export const cartSlice = createSlice({
  name: 'cart',
  initialState,
  reducers: {
    addToCart: (state, action) => {
      state.items.push(action.payload.item);
    }
  }
});

export const cartReducer = cartSlice.reducer;
export const { addToCart } = cartSlice.actions;
