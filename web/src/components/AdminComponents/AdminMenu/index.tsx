import * as S from './styles';

import { IoNotifications as NottificationsIcons } from 'react-icons/io5';
import { BiSearch as SearchIcon } from 'react-icons/bi';

export function AdminMenu() {
  return (
    <S.Wrapper>
      <S.LeftArea>
        <h1>Ed Burguer</h1>
        <S.Search>
          <button type="submit">
            <SearchIcon size={15} />
          </button>
          <input type="text" placeholder="Search" />
        </S.Search>
      </S.LeftArea>
      <S.RightArea>
        <p>Aberto para pedidos</p>
        <NottificationsIcons />
        <p>User</p>
      </S.RightArea>
    </S.Wrapper>
  );
}
