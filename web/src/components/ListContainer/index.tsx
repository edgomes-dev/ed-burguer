import * as S from './styles';

type item = {
  title: string;
  image: string;
  price?: number;
};

type ListContainerProps = {
  title: string;
  columns: 'one' | 'two';
  items: item[];
};

export function ListContainer({ title, columns, items }: ListContainerProps) {
  return (
    <S.Wrapper>
      <h2>{title}</h2>
      <S.Container>Item</S.Container>
    </S.Wrapper>
  );
}
