import { AdminMenu } from '@/components/AdminComponents/AdminMenu';
import * as S from './styles';
import { AdminMenuLeft } from '@/components/AdminComponents/AdminMenuLeft';
import { ReactNode } from 'react';

interface IProps {
  children: ReactNode;
}

export function AdminBasetemplate({ children }: IProps) {
  return (
    <S.Wrapper>
      <AdminMenuLeft />
      <AdminMenu />
      <S.Content>{children}</S.Content>
    </S.Wrapper>
  );
}
