import Image from 'next/image';
import * as S from './styles';
import { OptionType, ProductType } from '@/pages';

import { GrFormAdd as AddIcon } from 'react-icons/gr';
import { ModalProduct } from '../ModalProduct';
import { useState } from 'react';

export type ListItemProps = {
  category: string;
  product: ProductType;
  options: OptionType[];
};

export function ListItem({ category, product, options }: ListItemProps) {
  const [visibleModal, setVisibleModal] = useState(false);

  return (
    <>
      <S.Wrapper visible={visibleModal} onClick={() => setVisibleModal(true)}>
        <Image
          src={'/img/' + product.imageUrl}
          alt={product.name}
          width={150}
          height={150}
        />
        <S.Content>
          <h3>{product.name}</h3>
          {!!product.description && <p>{product.description}</p>}
          <span>
            {product.price.toLocaleString('pt-BR', {
              style: 'currency',
              currency: 'BRL'
            })}
          </span>
        </S.Content>
        <S.Button>
          <AddIcon />
        </S.Button>
      </S.Wrapper>
      <ModalProduct
        visible={visibleModal}
        closeModal={() => setVisibleModal(false)}
        category={category}
        product={product}
        options={options}
      />
    </>
  );
}
