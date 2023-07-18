import Link from 'next/link';
import * as S from './styles';

import { AiOutlineShoppingCart as ShoppingCart } from 'react-icons/ai';
import { MdAccountCircle as AccountIcon } from 'react-icons/md';
import { useState } from 'react';

const price = 0.0;

export function Menu() {
  const [accountHidden, setAccountHidden] = useState(true);

  return (
    <S.Wrapper>
      <ul>
        <Link href="/">
          <li>Inicio</li>
        </Link>
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
