import Link from 'next/link';
import * as S from './styles';

import {
  AiOutlineShoppingCart as ShoppingCart,
  AiOutlineMenu as MenuIcon
} from 'react-icons/ai';
import { MdAccountCircle as AccountIcon } from 'react-icons/md';
import { useState } from 'react';
import { MenuLeft } from '../MenuLeft';

const price = 0.0;

export function Menu() {
  const [accountHidden, setAccountHidden] = useState(true);
  const [visibleMenuLeft, setVisibleMenuLeft] = useState(false);

  function closeIcon() {
    return setVisibleMenuLeft(false);
  }

  return (
    <S.Wrapper>
      <MenuLeft visible={visibleMenuLeft} closeMenu={() => closeIcon()} />
      <ul>
        <S.LeftArea>
          <MenuIcon onClick={(e) => setVisibleMenuLeft(!visibleMenuLeft)} />
          <Link href="/">Inicio</Link>
        </S.LeftArea>
        <S.RightArea>
          <S.Cart>
            <ShoppingCart size={24} />
            <span>
              {price.toLocaleString('pt-BR', {
                style: 'currency',
                currency: 'BRL'
              })}
            </span>
          </S.Cart>
          <S.Account account={accountHidden}>
            <span>
              <AccountIcon
                onClick={() => setAccountHidden(!accountHidden)}
                size={28}
              />
            </span>
            <ul>
              <li>
                <Link href="/login">Fazer login</Link>
              </li>
            </ul>
          </S.Account>
        </S.RightArea>
      </ul>
    </S.Wrapper>
  );
}
