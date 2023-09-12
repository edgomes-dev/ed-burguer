import { useState } from 'react';
import * as S from './styles';
import { IoIosArrowDown as ArrowIcon } from 'react-icons/io';

type MenuLeftItemProps = {
  title: string;
  children?: React.ReactNode;
};

export function MenuLeftItem({ title, children }: MenuLeftItemProps) {
  const [contentVisible, setContentVisible] = useState(false);

  return (
    <S.Wrapper>
      <S.Item>
        <S.Menu>
          <p>{title}</p>
          <ArrowIcon onClick={(e) => setContentVisible(!contentVisible)} />
        </S.Menu>
        <S.Content visible={contentVisible}>{children}</S.Content>
      </S.Item>
    </S.Wrapper>
  );
}
