import * as S from './styles';
import { AiFillCheckCircle as Checked } from 'react-icons/ai';
import { useState } from 'react';
import { Counter } from '@/components/Counter';
import { IngredientType } from '@/pages';

type InputPriceProps = {
  ingredient: IngredientType;
  required: boolean;
  changeItemsLimit: (operator: '+' | '-') => boolean | void;
  changeIngredientsPrice: (operator: '+' | '-', price: number) => void;
};

export function InputPrice({
  ingredient,
  required = false,
  changeItemsLimit,
  changeIngredientsPrice
}: InputPriceProps) {
  const [quantity, setQuantity] = useState(0);

  function changeQuantity(operator: '+' | '-') {
    if (quantity === ingredient.repetitions && operator === '+') return;
    if (operator === '+') {
      if (changeItemsLimit('+')) return;
      setQuantity(quantity + 1);
      changeIngredientsPrice('+', ingredient.price);
    }
    if (quantity === 0 && operator === '-') return;
    if (operator === '-') {
      if (changeItemsLimit('-')) return;
      setQuantity(quantity - 1);
      changeIngredientsPrice('-', ingredient.price);
    }
  }

  if (required) {
    return (
      <S.Wrapper required={required}>
        <S.Content>
          {ingredient.name}
          <input type="radio" name="option" value={ingredient.id} />
        </S.Content>
      </S.Wrapper>
    );
  } else {
    return (
      <S.Wrapper required={required}>
        <S.Content>
          <p>{ingredient.name}</p>
          <S.Price>
            <p className="item">
              (+
              {ingredient.price
                ? ingredient.price.toLocaleString('pt-BR', {
                    style: 'currency',
                    currency: 'BRL'
                  })
                : '0'}
              )
            </p>
            <Counter
              value={quantity}
              size="small"
              maxItems={ingredient.repetitions}
              changeQuantity={(operator: '+' | '-') => changeQuantity(operator)}
            />
          </S.Price>
        </S.Content>
      </S.Wrapper>
    );
  }
}
