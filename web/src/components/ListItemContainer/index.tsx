import * as S from './styles';

export type ListItemContainerProps = {
  text: string;
  img: string;
  link?: string;
};

export function ListItemContainer({ img, text }: ListItemContainerProps) {
  return <S.Wrapper image={img}>{text}</S.Wrapper>;
}
