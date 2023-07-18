import { IngredientsItem, IngredientsItemType } from '../IngredientsItem';
import * as S from './styles';

export type IngredientsListProps = {
  title: string;
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

export function IngredientsList({
  title,
  options,
  items,
  changeValue,
  complement,
  handleComplementOrAdditional
}: IngredientsListProps) {
  return (
    <S.Wrapper>
      <S.Title complement={complement}>
        <h4>
          {title} (até {options} ite{options > 1 ? 'ns' : 'm'})
        </h4>
        <p>{complement ? 'OBRIGATORIO' : 'OPCIONAL'}</p>
      </S.Title>
      <IngredientsItem
        options={options}
        items={items}
        changeValue={changeValue}
        complement={complement}
        handleComplementOrAdditional={handleComplementOrAdditional}
      />
    </S.Wrapper>
  );
}
