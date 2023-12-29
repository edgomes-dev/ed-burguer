import Image from 'next/image';
import * as S from './styles';
import { AiOutlineClose as CloseIcon } from 'react-icons/ai';
import { OptionType, ProductType } from '@/pages';
import { useEffect, useState } from 'react';
import { Counter } from '../Counter';
import { useDispatch } from 'react-redux';
import { OptionsList } from '../OptionsList';
import { useRouter } from 'next/navigation';
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
  const router = useRouter();
  const [quantity, setQuantity] = useState(1);
  const [productPrice, setProductPrice] = useState(0);
  const [ingredientsPrice, setIngredientsPrice] = useState(0);
  const [observation, setObservation] = useState('');

  const handleAddToCart = (
    product_id: number,
    name: string,
    image_url: string,
    observartion: string,
    price: number,
    quantity: number
  ) => {
    dispatch(
      addToCart({
        price,
        product: { product_id, name, image_url, observartion, price, quantity }
      })
    );
    router.push('/');
  };

  function changeQuantity(operator: '+' | '-') {
    if (quantity === 20 && operator === '+') return;
    if (operator === '+') setQuantity(quantity + 1);
    if (quantity === 1 && operator === '-') return;
    if (operator === '-') setQuantity(quantity - 1);
  }

  function changeIngredientsPrice(operator: '+' | '-', price: number) {
    if (operator == '+') setIngredientsPrice(ingredientsPrice + price);
    if (operator == '-') setIngredientsPrice(ingredientsPrice - price);
  }

  useEffect(() => {
    setProductPrice(product.price * quantity + ingredientsPrice);
  }, [product.price, quantity, ingredientsPrice]);

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
            <OptionsList
              key={option.id}
              option={option}
              changeIngredientsPrice={(operator: '+' | '-', price: number) =>
                changeIngredientsPrice(operator, price)
              }
            />
          ))}
        </S.OptionContainer>
        <S.Observation>
          <h3>Observações</h3>
          <textarea
            value={observation}
            onChange={(e) => setObservation(e.target.value)}
            placeholder="Escreva as observações do produto aqui"
          />
        </S.Observation>
      </S.Content>
      <S.Footer>
        <S.Counter>
          <p>Quantidade</p>
          <Counter
            value={quantity}
            maxItems={20}
            size="large"
            changeQuantity={(operator: '+' | '-') => {
              changeQuantity(operator);
            }}
          />
        </S.Counter>
        <S.Button
          onClick={() =>
            handleAddToCart(
              product.id,
              product.name,
              product.imageUrl,
              observation,
              productPrice,
              quantity
            )
          }
        >
          <p>Adicionar</p>
          <span>
            {productPrice.toLocaleString('pt-BR', {
              style: 'currency',
              currency: 'BRL'
            })}
          </span>
        </S.Button>
      </S.Footer>
    </S.Wrapper>
  );
}

/*

<S.Button>
          <button
            type="button"
            onClick={() =>
              handleAddToCart(
                product.id,
                product.name,
                product.imageUrl,
                observation,
                productPrice,
                quantity
              )
            }
          >
            teste
          </button>
          <p>Adicionar</p>
          <span>
            {productPrice.toLocaleString('pt-BR', {
              style: 'currency',
              currency: 'BRL'
            })}
          </span>
        </S.Button>

*/
