import * as S from './styles';
import { ListItem } from '../ListItem';
import { ProductCategoryType } from '@/pages';
import Image from 'next/image';

import { IoIosArrowDown as ArrowIcon } from 'react-icons/io';
import { useState } from 'react';

export function ListContainer({
  id,
  name,
  imageUrl,
  options,
  products
}: ProductCategoryType) {
  const [vissible, setVissible] = useState(true);

  return (
    <S.Wrapper id={`${id}`} key={id}>
      <S.Menu>
        <div>
          <Image src={'/img/' + imageUrl} alt={name} width={35} height={35} />
          <h2>{name}</h2>
        </div>
        <ArrowIcon onClick={(e) => setVissible(!vissible)} />
      </S.Menu>
      <S.Container visible={vissible}>
        {products.map((product) => (
          <ListItem
            key={product.id}
            category={name}
            product={product}
            options={options}
          />
        ))}
      </S.Container>
    </S.Wrapper>
  );
}
