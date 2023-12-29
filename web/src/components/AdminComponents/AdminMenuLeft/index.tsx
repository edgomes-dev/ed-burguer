import Link from 'next/link';
import * as S from './styles';

import {
  BsFillBoxFill as BoxOrders,
  BsFillBagCheckFill as OrderHistory
} from 'react-icons/bs';

import {
  AiOutlinePercentage as Offers,
  AiFillHome as StockIcon
} from 'react-icons/ai';
import {
  FiShoppingBag as ProductsIcon,
  FiSettings as SettingsIcon
} from 'react-icons/fi';
import { BiMessageDetail as MessageIcon } from 'react-icons/bi';

import { IoNewspaper } from 'react-icons/io5';

export function AdminMenuLeft() {
  return (
    <S.Wrapper>
      <S.TopArea>
        <ul>
          <li>
            <Link href="/admin">
              <StockIcon size={30} /> Central
            </Link>
          </li>
          <li>
            <Link href="/admin/order/history">
              <OrderHistory size={30} /> Pedidos
            </Link>
          </li>
          <li>
            <Link href="/admin/order/history">
              <IoNewspaper size={30} /> Cardápio
            </Link>
          </li>
        </ul>
      </S.TopArea>
      <S.BottomArea>
        <li>
          <Link href="/">
            <ProductsIcon size={30} /> Estoque
          </Link>
        </li>
        <li>
          <Link href="/">
            <SettingsIcon size={30} /> Settings
          </Link>
        </li>
      </S.BottomArea>
    </S.Wrapper>
  );
}
