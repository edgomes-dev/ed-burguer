import { api } from '@/utils/axios';
import * as S from './styles';
import { useEffect, useState } from 'react';
import { TableItem } from '../TableItem';

interface IProductOrder {
  id: number;
  product: {
    id: number;
    name: string;
    imageUrl: string;
    description: string;
    price: number;
  };
  orderOptions: [
    {
      id: number;
      title: string;
    }
  ];
  observation: string;
  quantity: number;
}

export interface IOrder {
  id: number;
  status: string;
  payment: string;
  receiveType: string;
  cpf: string;
  price: number;
  productOrder: IProductOrder[];
  user: {
    id: number;
    name: string;
    phone: string;
  };
  addresses: {
    id: number;
    name: string;
    street: string;
    number: string;
    complement: string;
    district: {
      id: number;
      name: string;
      deliveryPrice: number;
    };
  };
}

interface Props {
  title: string;
}

export function Table({ title }: Props) {
  const [orders, setOrders] = useState<IOrder[]>([]);

  useEffect(() => {
    api('/orders').then((res) => setOrders(res.data));
  }, []);

  return (
    <S.Wrapper>
      <S.Title>
        <h2>{title}</h2>
        <span>{orders.length}</span>
      </S.Title>
      <S.Table>
        <thead>
          <tr>
            <td>id</td>
            <td>Cliente</td>
            <td>Telefone</td>
            <td>Preço</td>
            <td>Status</td>
          </tr>
        </thead>
        <tbody>
          {orders.map((order) => (
            <TableItem key={order.user.name + order.id} order={order} />
          ))}
        </tbody>
      </S.Table>
    </S.Wrapper>
  );
}
