import { PersistPartial } from 'redux-persist/lib/persistReducer';
import * as S from './styles';

import {
  BsFillTrashFill as TrashIcon,
  BsPenFill as PenIcon
} from 'react-icons/bs';
import { ICart } from '@/redux/cartSlice';
import Image from 'next/image';
import { Counter } from '../Counter';

interface IProps {
  cart: ICart & PersistPartial;
}

export function ItemsOrder({ cart }: IProps) {
  return (
    <S.Wrapper>
      <h2>Meu Pedido</h2>
      {cart.products.map((product) => (
        <>
          <S.Product key={product.name}>
            <S.LeftArea>
              <Image
                src={'/img/' + product.image_url}
                width={125}
                height={125}
                alt={product.name}
              />
              <div>
                <p>{product.name}</p>
                {product.observartion && (
                  <span>OBS: {product.observartion}</span>
                )}
                <div className="priceArea">
                  {product.price.toLocaleString('pt-BR', {
                    style: 'currency',
                    currency: 'BRL'
                  })}
                  <Counter
                    value={product.quantity}
                    maxItems={5}
                    size="small"
                    key={product.name}
                    changeQuantity={() => console.log()}
                  />
                </div>
              </div>
            </S.LeftArea>
            <S.RightArea>
              <div>
                <TrashIcon size={18} />
              </div>
              <div id="twoIcon">
                <PenIcon size={18} />
              </div>
            </S.RightArea>
          </S.Product>
          <S.ProductOptional>
            <div>
              <p>1x prensado</p>
            </div>
            <div>
              <p>1x bacon</p>
              <span>R$ 6,00</span>
            </div>
            <div>
              <p>1x salsicha</p>
              <span>R$ 2,00</span>
            </div>
          </S.ProductOptional>
        </>
      ))}
    </S.Wrapper>
  );
}
