import { ListContainer } from '@/components/ListContainer';
import { Menu } from '@/components/Menu';

import * as S from './styles';
import { ProductCategoryType } from '@/pages';
import { Slider } from '@/components/Slider';

type HomeTemplatePropsType = {
  data: ProductCategoryType[];
};

export function HomeTemplate({ data }: HomeTemplatePropsType) {
  const settings = {
    dots: true,
    infinite: false,
    speed: 500,
    slidesToShow: 3,
    slidesToScroll: 3
  };

  console.log(data);

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
          <Slider data={data} />
        </S.Category>
        {data.map((category) => (
          <ListContainer
            key={category.id}
            id={category.id}
            imageUrl={category.imageUrl}
            name={category.name}
            options={category.options}
            products={category.products}
          />
        ))}
      </S.Wrapper>
    </>
  );
}
