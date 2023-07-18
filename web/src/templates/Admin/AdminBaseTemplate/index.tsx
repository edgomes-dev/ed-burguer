import { AdminMenu } from '@/components/AdminComponents/AdminMenu';
import * as S from './styles';
import { AdminMenuLeft } from '@/components/AdminComponents/AdminMenuLeft';

export function AdminBasetemplate() {
  return (
    <S.Wrapper>
      <AdminMenuLeft />
      <AdminMenu />
      <S.Content>test</S.Content>
    </S.Wrapper>
  );
}
