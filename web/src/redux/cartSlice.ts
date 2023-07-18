import { createSlice } from '@reduxjs/toolkit';

type CartItemType = {
  category: string;
  productName: string;
  img: string;
  description?: string;
  complement: {
    title: string;
    itens: string[];
  };
  adicionais?: string[];
  quantity: number;
  price: number;
  observation: string;
};

export interface CartSlice {
  itens: CartItemType[];
}

const initialState: CartSlice = {
  itens: []
};

export const cartSlice = createSlice({
  name: 'cart',
  initialState,
  reducers: {
    addToCart: (state, { payload }) => {
      state.itens.push(payload);
    }
  }
});

export const { addToCart } = cartSlice.actions;

export default cartSlice.reducer;
