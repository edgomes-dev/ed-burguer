import { IngredientType, OptionType } from '@/pages';
import { IngredientsItem, IngredientsItemType } from '../IngredientsItem';
import * as S from './styles';

type IngredientsListProps = {
  option: OptionType;
  //changeValue: (add: number, sub: number) => void;
};

export function IngredientsList({ option }: IngredientsListProps) {
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
      {option.required && <p>{option.optionsRequired}</p>}
      <IngredientsItem
        options={option.maximumAmount}
        items={option.ingredients}
      />
    </S.Wrapper>
  );
}
