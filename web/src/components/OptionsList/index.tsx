import { IngredientType, OptionType } from '@/pages';
import * as S from './styles';
import { OptionsListItem } from '../OptionsListItem';
import { InputPrice } from '@/utils/InputPrice';
import { useState } from 'react';

type OptionsListProps = {
  option: OptionType;
  changeIngredientsPrice: (operator: '+' | '-', price: number) => void;
};

export function OptionsList({
  option,
  changeIngredientsPrice
}: OptionsListProps) {
  const [itemsLimit, setItemslimit] = useState(0);

  function changeItemsLimit(operator: '+' | '-') {
    if (operator === '+') {
      if (itemsLimit === option.maximumAmount) return true;
      setItemslimit(itemsLimit + 1);
    }
    if (operator === '-') {
      if (itemsLimit === 0) return true;
      setItemslimit(itemsLimit - 1);
    }
  }

  return (
    <S.Wrapper>
      <S.Title complement={option.required}>
        <h4>
          {option.name}{' '}
          <span>
            (até {option.maximumAmount} ite
            {option.maximumAmount > 1 ? 'ns' : 'm'})
          </span>
        </h4>
        <p>{option.required ? 'OBRIGATORIO' : 'OPCIONAL'}</p>
      </S.Title>
      {option.ingredients.map((item) => (
        <InputPrice
          key={item.id}
          ingredient={item}
          required={option.required}
          changeItemsLimit={(operator: '+' | '-') => changeItemsLimit(operator)}
          changeIngredientsPrice={(operator: '+' | '-', price: number) =>
            changeIngredientsPrice(operator, price)
          }
        />
      ))}
    </S.Wrapper>
  );
}
