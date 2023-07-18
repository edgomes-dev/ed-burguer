import Image from 'next/image';
import * as S from './styles';

export type ListItemProps = {
  text: string;
  img: string;
  link?: string;
  price: number;
  description: string;
};

export function ListItem({ text, img, price, description }: ListItemProps) {
  return (
    <S.Wrapper>
      <Image width={100} height={100} src={img} alt={text} />
      <S.Content>
        <h3>{text}</h3>
        {!!description && <p>{description}</p>}
        <span>
          {price.toLocaleString('pt-BR', {
            style: 'currency',
            currency: 'BRL'
          })}
        </span>
      </S.Content>
    </S.Wrapper>
  );
}
