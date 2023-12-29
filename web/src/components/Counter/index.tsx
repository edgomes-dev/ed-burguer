import * as S from './styles';

export type CounterProps = {
  value: number;
  maxItems: number;
  size: 'large' | 'small';
  changeQuantity: (operator: '+' | '-') => void;
};

export function Counter({ value, size, changeQuantity }: CounterProps) {
  return (
    <S.Wrapper size={size}>
      <button onClick={() => changeQuantity('-')}>-</button>
      <p>{value}</p>
      <button onClick={() => changeQuantity('+')}>+</button>
    </S.Wrapper>
  );
}

/*



*/
