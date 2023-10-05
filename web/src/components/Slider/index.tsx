import { useSliderScript } from '@/utils/sliderScript';
import * as S from './styles';
import Image from 'next/image';
import { useEffect } from 'react';

import {
  AiOutlineArrowLeft as ArrowLeftIcon,
  AiOutlineArrowRight as ArrowRightIcon
} from 'react-icons/ai';

type ProductCategory = {
  name: string;
  imageUrl: string;
};

type SliderPropsType = {
  data: ProductCategory[];
};

export function Slider({ data }: SliderPropsType) {
  useSliderScript();

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
      <S.SliderMobile>
        <ArrowLeftIcon id="prev" />
        <nav id="slider">
          {data.map((item) => (
            <li key={item.name}>{item.name}</li>
          ))}
        </nav>
        <ArrowRightIcon id="next" />
      </S.SliderMobile>
    </S.Wrapper>
  );
}
