import * as S from './styles';

import { RiShoppingBag2Fill as OrdersIcon } from 'react-icons/ri';
import { BsClockFill as PendingIcon } from 'react-icons/bs';
import { GiFullMotorcycleHelmet as DispatchIcon } from 'react-icons/gi';
import { Table } from '@/components/AdminComponents/Table';
import { useRouter } from 'next/router';

export const data = [
  {
    'Country Name': 'Afghanistan',
    Capital: 'Kabul',
    Currency: 'Afghani'
  },
  {
    'Country Name': 'Albania',
    Capital: 'Tirane',
    Currency: 'Lek'
  },
  {
    'Country Name': 'Algeria',
    Capital: 'Algiers',
    Currency: 'Dinar'
  }
];

const statusType = {
  RequestAccepted: 'Pedidos em Espera',
  OrderPreparation: 'Pedidos em Preparo',
  OrderDelivered: 'Pedidos em Entrega',
  OrderFinish: 'Pedidos Finalizados'
} as const;

type StatusType = keyof typeof statusType;

export function AdminOrdersTemplate() {
  const router = useRouter;
  const params = router().query;
  const order = params.order;
  let orderStatus;

  if (typeof order === 'string' && order in statusType) {
    orderStatus = statusType[order as StatusType];
  } else {
    orderStatus = 'Pedido em Espera';
  }

  return (
    <S.Wrapper>
      <S.Cards>
        <S.Card>
          <div>
            <OrdersIcon size={45} className="icon" />
            <span>47</span>
          </div>
          <p>Pedidos Finalizados</p>
        </S.Card>
        <S.Card>
          <div>
            <PendingIcon size={45} className="icon" />
            <span>56</span>
          </div>
          <p>Pedidos em Espera</p>
        </S.Card>
        <S.Card>
          <div>
            <PendingIcon size={45} className="icon" />
            <span>56</span>
          </div>
          <p>Pedidos em Preparo</p>
        </S.Card>
        <S.Card>
          <div>
            <DispatchIcon size={45} className="icon" />
            <span>26</span>
          </div>
          <p>Em entrega</p>
        </S.Card>
      </S.Cards>
      <S.Orders>
        <Table title={orderStatus} />
      </S.Orders>
    </S.Wrapper>
  );
}
