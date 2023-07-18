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

export function AdminMenuLeft() {
  return (
    <S.Wrapper>
      <p>Ed Burguer</p>
      <S.Content>
        <ul>
          <li>
            <Link href="/">
              <BoxOrders /> Live order
            </Link>
          </li>
          <li>
            <Link href="/">
              <OrderHistory /> Order History
            </Link>
          </li>
          <li>
            <Link href="/">
              <Offers /> Offers
            </Link>
          </li>
          <li>
            <Link href="/">
              <ProductsIcon /> Products
            </Link>
          </li>
          <li>
            <Link href="/">
              <StockIcon /> Stock
            </Link>
          </li>
          <li>
            <Link href="/">
              <MessageIcon /> Message
            </Link>
          </li>
          <li>
            <Link href="/">
              <SettingsIcon /> Settings
            </Link>
          </li>
        </ul>
      </S.Content>
      <p>Dark mode</p>
    </S.Wrapper>
  );
}
