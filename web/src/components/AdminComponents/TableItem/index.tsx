import { useState } from 'react';
import { ModalOrderDetails } from '../ModalOrderDetails';
import { IOrder } from '../Table';
import * as S from './styles';

interface IProps {
  order: IOrder;
}

export function TableItem({ order }: IProps) {
  const [visible, setVisible] = useState(false);

  return (
    <>
      <S.Wrapper onClick={() => setVisible(true)}>
        <td>{order.id}</td>
        <td>{order.user.name}</td>
        <td>{order.user.phone}</td>
        <td>{order.price}</td>
        <td>{order.receiveType}</td>
      </S.Wrapper>
      <ModalOrderDetails
        visible={visible}
        closeModal={() => setVisible(false)}
        order={order}
      />
    </>
  );
}
