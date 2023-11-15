import Image from 'next/image';
import { IngredientsList } from '../IngredientsList';
import * as S from './styles';
import { IngredientsItemType } from '../IngredientsItem';
import { AiOutlineClose as CloseIcon } from 'react-icons/ai';
import { OptionType, ProductType } from '@/pages';
import { useState } from 'react';
import { Counter } from '../Counter';
import { useDispatch } from 'react-redux';
import { addToCart } from '@/redux/cartSlice';

type ModalProductProps = {
  visible: boolean;
  closeModal: () => void;
  category: string;
  product: ProductType;
  options: OptionType[];
};
export function ModalProduct({
  visible,
  closeModal,
  category,
  product,
  options
}: ModalProductProps) {
  const dispatch = useDispatch();

  return (
    <S.Wrapper visible={visible}>
      <S.Menu>
        <CloseIcon
          onClick={closeModal}
          className="close"
          size={24}
          height={24}
        />
        <div>
          <p>{product.name}</p>
          <div>{category}</div>
        </div>
      </S.Menu>
      <S.Content>
        <div className="image">
          <Image
            src={'/img/' + product.imageUrl}
            width={300}
            height={300}
            alt={product.name}
          />
        </div>
        {product.description && (
          <p className="description">{product.description}</p>
        )}
        <S.OptionContainer>
          {options.map((option) => (
            <IngredientsList key={option.id} option={option} />
          ))}
        </S.OptionContainer>
        <S.Observation>
          <h3>Observações</h3>
          <textarea placeholder="Escreva as observações do produto aqui"></textarea>
        </S.Observation>
        <button onClick={() => dispatch(addToCart({ item: product.name }))}>
          Adicionar teste
        </button>
      </S.Content>
      <S.Footer>
        <S.Counter>
          <p>Quantidade</p>
          <Counter initialValue={1} maxItems={20} size="large" />
        </S.Counter>
        <S.Button>
          <p>Adicionar</p>
          <span>
            {product.price.toLocaleString('pt-BR', {
              style: 'currency',
              currency: 'BRL'
            })}
          </span>
        </S.Button>
      </S.Footer>
    </S.Wrapper>
  );
}
