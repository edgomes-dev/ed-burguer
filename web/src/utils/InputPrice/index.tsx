import { IngredientsItemType } from '@/components/IngredientsItem';
import * as S from './styles';
import { AiFillCheckCircle as Checked } from 'react-icons/ai';
import { useState } from 'react';

type InputPriceProps = {
  changeValue: (add: number, sub: number) => void;
  limitCheked: (add: number, sub: number) => boolean;
  complement: boolean;
  handleComplementOrAdditional: (
    isComplement: boolean,
    item: string,
    isDelete: boolean
  ) => void;
} & IngredientsItemType;

export function InputPrice({
  id,
  text,
  price,
  changeValue,
  complement,
  handleComplementOrAdditional,
  limitCheked
}: InputPriceProps) {
  const [selected, setSelected] = useState(false);

  const handlePrice = (checked: boolean) => {
    if (checked === true) {
      limitCheked(0, 1);
      changeValue(0, price);
      handleComplementOrAdditional(complement, text, true);

      return setSelected(false);
    }

    if (selected === false) {
      if (limitCheked(1, 0)) {
        changeValue(price, 0);
        handleComplementOrAdditional(complement, text, false);

        return setSelected(true);
      } else {
        console.log('Limite atingido');

        return setSelected(false);
      }
    }
  };

  return (
    <S.Wrapper key={id}>
      <input type="checkbox" name={`${id}`} checked={selected} readOnly />
      <S.Content
        onClick={(e) => {
          e.preventDefault();
          handlePrice(selected);
        }}
      >
        <p>{text}</p>
        <S.Price>
          <p>
            {price.toLocaleString('pt-BR', {
              style: 'currency',
              currency: 'BRL'
            })}
          </p>
          <span className="checked">
            <Checked color="green" />
          </span>
        </S.Price>
      </S.Content>
    </S.Wrapper>
  );
}
