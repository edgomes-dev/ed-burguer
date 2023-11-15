import Link from 'next/link';
import * as S from './styles';

import {
  AiOutlineShoppingCart as ShoppingCart,
  AiOutlineMenu as MenuIcon,
  AiOutlineClose as CloseIcon
} from 'react-icons/ai';
import { FiSearch as SearchIcon } from 'react-icons/fi';
import { MdAccountCircle as AccountIcon } from 'react-icons/md';
import { useState } from 'react';
import { MenuLeft } from '../MenuLeft';

const price = 0.0;

export function Menu() {
  const [accountHidden, setAccountHidden] = useState(true);
  const [visibleMenuLeft, setVisibleMenuLeft] = useState(false);
  const [search, setSearch] = useState(false);

  function closeIcon() {
    return setVisibleMenuLeft(false);
  }

  return (
    <S.Wrapper>
      <MenuLeft visible={visibleMenuLeft} closeMenu={() => closeIcon()} />
      <ul>
        <S.Search search={search}>
          <input type="search" placeholder="Pesquisar" />
          <CloseIcon size={28} color="#fff" onClick={() => setSearch(false)} />
        </S.Search>
        <S.LeftArea>
          <MenuIcon onClick={(e) => setVisibleMenuLeft(!visibleMenuLeft)} />
          <Link href="/">Ed Burguer</Link>
        </S.LeftArea>
        <S.RightArea search={search}>
          <S.Cart>
            <Link href="/cart">
              <ShoppingCart color="#fff" size={28} />
            </Link>
            <span>
              {price.toLocaleString('pt-BR', {
                style: 'currency',
                currency: 'BRL'
              })}
            </span>
          </S.Cart>
          <S.Account>
            <span>
              <AccountIcon
                onClick={() => setAccountHidden(!accountHidden)}
                size={28}
              />
            </span>
          </S.Account>
          <SearchIcon
            id="searchButton"
            size={28}
            color="#fff"
            onClick={() => setSearch(true)}
          />
        </S.RightArea>
      </ul>
    </S.Wrapper>
  );
}
