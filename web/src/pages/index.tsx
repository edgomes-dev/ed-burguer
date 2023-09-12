import { HomeTemplate } from '@/templates/HomeTemplate';
import { GetStaticProps, InferGetStaticPropsType } from 'next';
import { useEffect, useState } from 'react';

export type IngredientType = {
  id: number;
  name: string;
  description: string;
  price: number;
  repetitions: number;
};

export type OptionType = {
  id: number;
  name: string;
  maximumAmount: number;
  required: boolean;
  optionsRequired: string | null;
  ingredients: IngredientType[];
};

export type ProductType = {
  id: number;
  name: string;
  imageUrl: string;
  description: string;
  price: number;
  repetitions: boolean;
};

export type ProductCategoryType = {
  id: number;
  name: string;
  imageUrl: string;
  options: OptionType[];
  products: ProductType[];
};

export const getStaticProps: GetStaticProps = async (context) => {
  const res = await fetch('http://localhost:8082/ed-burguer/product-category');
  const data: ProductCategoryType[] = await res.json();

  return {
    props: { data }
    //revalidate: 60
  };
};

export default function myApp({
  data
}: InferGetStaticPropsType<typeof getStaticProps>) {
  return <>{data && <HomeTemplate data={data} />}</>;
}
