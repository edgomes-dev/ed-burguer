import * as S from './styles';
import Image from 'next/image';
import { IProductCategory } from '@/pages';

type SliderPropsType = {
  data: IProductCategory[];
};

export function Slider({ data }: SliderPropsType) {
  return (
    <S.Wrapper>
      <S.Title>
        <h2>Categorias</h2>
        <button>ver todas</button>
      </S.Title>
      <S.Slider>
        {data.map((item) => (
          <S.Item key={item.name}>
            <Image
              src={'/img/' + item.imageUrl}
              alt={item.name}
              width={100}
              height={100}
            />
            {item.name}
          </S.Item>
        ))}
      </S.Slider>
    </S.Wrapper>
  );
}
