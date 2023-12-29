import { createSlice } from '@reduxjs/toolkit';
import { RootState } from './store';

type ProductType = {
  product_id: number;
  name: string;
  image_url: string;
  observartion: string;
  price: number;
  quantity: number;
  order_options?: [
    {
      title: string;
      ingredients: number[];
    }
  ];
};

export interface ICart {
  price: number;
  products: ProductType[];
}

const initialState: ICart = {
  price: 0,
  products: []
};

export const cartSlice = createSlice({
  name: 'cart',
  initialState,
  reducers: {
    addToCart: (state, action) => {
      state.price += action.payload.price;
      state.products.push(action.payload.product);
    }
  }
});

export const cartReducer = cartSlice.reducer;
export const { addToCart } = cartSlice.actions;
