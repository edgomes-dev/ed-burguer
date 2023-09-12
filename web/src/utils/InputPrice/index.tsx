import { IngredientsItemType } from '@/components/IngredientsItem';
import * as S from './styles';
import { AiFillCheckCircle as Checked } from 'react-icons/ai';
import { useState } from 'react';
import { Counter } from '@/components/Counter';
import { IngredientType } from '@/pages';

type InputPriceProps = {
  ingredient: IngredientType;
  limitCheked: (add: number, sub: number) => boolean;
};

export function InputPrice({ ingredient, limitCheked }: InputPriceProps) {
  const [selected, setSelected] = useState(false);

  const handlePrice = (checked: boolean) => {
    if (checked === true) {
      limitCheked(0, 1);

      return setSelected(false);
    }

    if (selected === false) {
      if (limitCheked(1, 0)) {
        return setSelected(true);
      } else {
        console.log('Limite atingido');

        return setSelected(false);
      }
    }
  };

  return (
    <S.Wrapper key={ingredient.id}>
      <input
        type="checkbox"
        name={`${ingredient.id}`}
        checked={selected}
        readOnly
      />
      <S.Content
        onClick={(e) => {
          e.preventDefault();
          handlePrice(selected);
        }}
      >
        <p>{ingredient.name}</p>
        <S.Price>
          <p className="item">
            (+
            {ingredient.price
              ? ingredient.price.toLocaleString('pt-BR', {
                  style: 'currency',
                  currency: 'BRL'
                })
              : 0}
            )
          </p>
          <Counter
            initialValue={0}
            maxItems={ingredient.repetitions}
            size="small"
          />
        </S.Price>
      </S.Content>
    </S.Wrapper>
  );
}

/*



*/
