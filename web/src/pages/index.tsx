import { HomeTemplate } from '@/templates/HomeTemplate';
import { GetStaticProps, InferGetStaticPropsType } from 'next';
import { useEffect, useState } from 'react';

export interface IProduct {
  id: string;
  name: string;
  imageUrl: string;
  description: string;
  price: number;
  repetitions: boolean;
}

export interface IProductCategory {
  id: string;
  name: string;
  imageUrl: string;
  products: IProduct[];
}

export const getStaticProps: GetStaticProps = async (context) => {
  const res = await fetch('http://localhost:8082/ed-burguer/product-category');
  const data: IProductCategory[] = await res.json();

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
