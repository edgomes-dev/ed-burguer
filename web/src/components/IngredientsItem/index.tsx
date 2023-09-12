import { InputPrice } from '@/utils/InputPrice';
import * as S from './styles';
import { useState } from 'react';
import { IngredientType } from '@/pages';

export type IngredientsItemType = {
  id: number;
  text: string;
  price: number;
};

type IngredientsItemProps = {
  options: number;
  items: IngredientType[];
};

export function IngredientsItem({ options, items }: IngredientsItemProps) {
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
          ingredient={item}
          limitCheked={handleLimitChecked}
        />
      ))}
    </S.Wrapper>
  );
}
