import { InputPrice } from '@/utils/InputPrice';
import * as S from './styles';
import { useState } from 'react';

export type IngredientsItemType = {
  id: number;
  text: string;
  price: number;
};

type IngredientsItemProps = {
  options: number;
  items: IngredientsItemType[];
  changeValue: (add: number, sub: number) => void;
  complement: boolean;
  handleComplementOrAdditional: (
    isComplement: boolean,
    item: string,
    isDelete: boolean
  ) => void;
};

export function IngredientsItem({
  options,
  items,
  changeValue,
  complement,
  handleComplementOrAdditional
}: IngredientsItemProps) {
  const [limitChecked, setLimitChecked] = useState<number[]>([]);

  const handleLimitChecked = (add: number, sub: number) => {
    if (sub > 0) {
      let arr = limitChecked;
      arr.pop();
      setLimitChecked(arr);

      return true;
    }

    if (limitChecked.length >= options) {
      return false;
    } else {
      let arr = limitChecked;
      arr.push(add);
      setLimitChecked(arr);
      return true;
    }
  };

  return (
    <S.Wrapper>
      {items.map((item) => (
        <InputPrice
          key={item.id}
          id={item.id}
          text={item.text}
          price={item.price}
          changeValue={changeValue}
          complement={complement}
          limitCheked={handleLimitChecked}
          handleComplementOrAdditional={handleComplementOrAdditional}
        />
      ))}
    </S.Wrapper>
  );
}