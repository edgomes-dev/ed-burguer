import { ListContainer } from '@/components/ListContainer';
import { Menu } from '@/components/Menu';

import * as S from './styles';
import { useEffect, useState } from 'react';
import { categoryItemType, categoryMock, itemsMock } from './mock';
import { ItemProps } from '@/components/ListContainer';
import Image from 'next/image';
import { Slider } from '@/components/Slider';
type CardaioTemplateProps = {
  slug: string;
};

export function HomeTemplate({ slug }: CardaioTemplateProps) {
  const [data, SetData] = useState<ItemProps[]>([]);

  useEffect(() => {
    SetData(itemsMock);
  }, [data]);

  const settings = {
    dots: true,
    infinite: false,
    speed: 500,
    slidesToShow: 3,
    slidesToScroll: 3
  };

  return (
    <>
      <Menu />
      <S.Wrapper>
        <S.Search>
          <input type="text" placeholder="Pesquisar" />
          <div>
            <p>Pedido mínimo:</p>
            <span>R$ 15,00</span>
          </div>
        </S.Search>
        <S.Category>
          <Slider />
        </S.Category>
        <p>{slug}</p>
        <ListContainer
          title="hamburgueres"
          type="description"
          items={data}
          icon={true}
        />
      </S.Wrapper>
    </>
  );
}
