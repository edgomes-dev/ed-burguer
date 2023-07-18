import * as S from './styles';

import { RiShoppingBag2Fill as OrdersIcon } from 'react-icons/ri';
import { BsClockFill as PendingIcon } from 'react-icons/bs';
import { GiFullMotorcycleHelmet as DispatchIcon } from 'react-icons/gi';
import { Table } from '@/components/AdminComponents/Table';

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

export function AdminOrders() {
  return (
    <S.Wrapper>
      <h2>Live Orders</h2>
      <S.Cards>
        <S.Card>
          <OrdersIcon className="icon" />
          <div>
            <span>47</span>
            <p>Orders</p>
          </div>
        </S.Card>
        <S.Card>
          <PendingIcon className="icon" />
          <div>
            <span>56</span>
            <p>Total Pending</p>
          </div>
        </S.Card>
        <S.Card>
          <DispatchIcon className="icon" />
          <div>
            <span>26</span>
            <p>Total Dispatch</p>
          </div>
        </S.Card>
      </S.Cards>
      <S.Orders>
        <h2>Orders</h2>
        <Table />
      </S.Orders>
    </S.Wrapper>
  );
}
