import Link from 'next/link';
import * as S from './styles';

import { BsFillBagCheckFill as OrderManager } from 'react-icons/bs';
import { AiFillHome as StockIcon } from 'react-icons/ai';
import { FiSettings as SettingsIcon } from 'react-icons/fi';

export function AdminMenuLeft() {
  return (
    <S.Wrapper>
      <h1>Ed Burguer</h1>
      <S.TopArea>
        <ul>
          <li>
            <Link href="/admin">
              <StockIcon size={30} /> Central
            </Link>
          </li>
          <li>
            <Link href="/admin/order/list/all">
              <OrderManager size={30} /> Pedidos
            </Link>
          </li>
        </ul>
      </S.TopArea>
      <S.BottomArea>
        <li>
          <Link href="/">
            <SettingsIcon size={30} /> Settings
          </Link>
        </li>
      </S.BottomArea>
    </S.Wrapper>
  );
}
