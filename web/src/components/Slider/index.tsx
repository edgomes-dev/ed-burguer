import * as S from './styles';
import { FaHamburger as IconHamburger } from 'react-icons/fa';
import {
  AiOutlineArrowLeft as IconLeft,
  AiOutlineArrowRight as IconRight
} from 'react-icons/ai';
import {
  DOMAttributes,
  HtmlHTMLAttributes,
  MouseEvent,
  MouseEventHandler,
  useRef
} from 'react';

export function Slider() {
  const slider = useRef<HTMLDivElement>(null);

  const handleLeftClick = (e: MouseEvent<HTMLButtonElement, MouseEvent>) => {
    e.preventDefault();
    if (slider.current != null) {
      slider.current.scrollLeft -= slider.current?.offsetWidth;
    }
  };

  const handleRightClick = (
    e: MouseEvent<HTMLButtonElement, MouseEvent>
  ): void => {
    e.preventDefault();
    if (slider.current != null) {
      slider.current.scrollLeft += slider.current?.offsetWidth;
    }
  };

  return (
    <S.Wrapper>
      <S.Title>
        <h2>Categorias</h2>
        <button>ver todas</button>
      </S.Title>
      <S.Slider ref={slider}>
        <S.Item>
          <IconHamburger />
          Hamburguer
        </S.Item>
        <S.Item>
          <IconHamburger />
          Hamburguer 2
        </S.Item>
        <S.Item>
          <IconHamburger />
          Hamburguer 3
        </S.Item>
        <S.Item>
          <IconHamburger />
          Hamburguer 4
        </S.Item>
        <S.Item>
          <IconHamburger />
          Hamburguer 5
        </S.Item>
        <S.Item>
          <IconHamburger />
          Hamburguer 6
        </S.Item>
        <S.Item>
          <IconHamburger />
          Hamburguer 7
        </S.Item>
        <S.Item>
          <IconHamburger />
          Hamburguer 8
        </S.Item>
        <S.Item>
          <IconHamburger />
          Hamburguer 9
        </S.Item>
      </S.Slider>
      <S.Buttons>
        <button onClick={handleLeftClick}>
          <IconLeft />
        </button>
        <button onClick={handleRightClick}>
          <IconRight />
        </button>
      </S.Buttons>
    </S.Wrapper>
  );
}
