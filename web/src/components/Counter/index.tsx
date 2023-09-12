import { useState } from 'react';
import * as S from './styles';

export type CounterProps = {
  initialValue: number;
  maxItems: number;
  size: 'large' | 'small';
};

export function Counter({ initialValue, maxItems, size }: CounterProps) {
  const value = initialValue;
  const [quantity, setQuantity] = useState(value);

  function changeQuantity(operator: 'mais' | 'menos') {
    if (quantity === maxItems && operator === 'mais') return;
    if (operator === 'mais') setQuantity(quantity + 1);
    if (quantity === value && operator === 'menos') return;
    if (operator === 'menos') setQuantity(quantity - 1);
  }

  return (
    <S.Wrapper size={size}>
      <button onClick={() => changeQuantity('menos')}>-</button>
      <p>{quantity}</p>
      <button onClick={() => changeQuantity('mais')}>+</button>
    </S.Wrapper>
  );
}

/*



*/
