import Image from 'next/image';
import * as S from './styles';
import { IProduct } from '@/pages';

import { GrFormAdd as AddIcon } from 'react-icons/gr';

export type ListItemProps = {
  data: IProduct;
};

export function ListItem({ data }: ListItemProps) {
  return (
    <S.Wrapper>
      <Image
        src={'/img/' + data.imageUrl}
        alt={data.name}
        width={150}
        height={150}
      />
      <S.Content>
        <h3>{data.name}</h3>
        {!!data.description && <p>{data.description}</p>}
        <span>
          {data.price.toLocaleString('pt-BR', {
            style: 'currency',
            currency: 'BRL'
          })}
        </span>
      </S.Content>
      <S.Button>
        <AddIcon />
      </S.Button>
    </S.Wrapper>
  );
}
