import { InputPrice } from '@/utils/InputPrice';
import * as S from './styles';
import { useState } from 'react';
import { IngredientType, OptionType } from '@/pages';

type OptionsListItemProps = {
  option: OptionType;
};

export function OptionsListItem({ option }: OptionsListItemProps) {
  const [limitChecked, setLimitChecked] = useState<number[]>([]);

  const handleLimitChecked = (add: number, sub: number) => {
    if (sub > 0) {
      let arr = limitChecked;
      arr.pop();
      setLimitChecked(arr);

      return true;
    }

    if (limitChecked.length >= option.maximumAmount) {
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
      {option.ingredients.map((item) => (
        <InputPrice key={item.id} ingredient={item} />
      ))}
    </S.Wrapper>
  );
}

/*

export function OptionsListItem({ option }: OptionsListItemProps) {
  const [limitChecked, setLimitChecked] = useState<number[]>([]);

  const handleLimitChecked = (add: number, sub: number) => {
    if (sub > 0) {
      let arr = limitChecked;
      arr.pop();
      setLimitChecked(arr);

      return true;
    }

    if (limitChecked.length >= option.maximumAmount) {
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
      {option.ingredients.map((item) => (
        <InputPrice
          key={item.id}
          ingredient={item}
          limitCheked={handleLimitChecked}
        />
      ))}
    </S.Wrapper>
  );
}

*/
