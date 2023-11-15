import Link from 'next/link';
import * as S from './styles';
import {
  AiOutlineShoppingCart as ShoppingCart,
  AiOutlineArrowLeft as ArrowLeftIcon
} from 'react-icons/ai';
import {
  BsFillTrashFill as TrashIcon,
  BsPenFill as PenIcon
} from 'react-icons/bs';
import Image from 'next/image';
import { Counter } from '@/components/Counter';
import { useSelector } from 'react-redux';
import { RootState } from '@/redux/store';

type ProductType = {
  image_url: string;
  name: string;
  quantity: number;
  price: number;
  observartion?: string;
};
const products: ProductType[] = [
  {
    image_url: '/img/02-08-2023-22-03-18hotdog-simples-min.jpg',
    name: 'Cachorro quente simples',
    quantity: 1,
    price: 5.99,
    observartion: 'Sem cebola'
  },
  {
    image_url: '/img/02-08-2023-22-06-44hotdog-amoroso-min.jpg',
    name: 'Cachorro quente Amoroso',
    quantity: 2,
    price: 16
  },
  {
    image_url: '/img/02-08-2023-22-06-10hotdog-caprichoso-min.jpg',
    name: 'Cachorro quente Caprichoso',
    quantity: 1,
    price: 29
  }
];

export function CartTemplate() {
  const cart = useSelector((state: RootState) => state.cart);
  console.log(cart);

  return (
    <S.Wrapper>
      <S.Menu>
        <Link href="/">
          <ArrowLeftIcon />
        </Link>
        <S.Button type="submit" value="Fazer Login" />
      </S.Menu>
      <S.Content>
        {cart.items.length === 0 ? (
          <>
            <Image
              src="/img/empty-cart.png"
              width={256}
              height={256}
              alt="Cart is empty"
            />
            <p className="title">Seu carrinho está vázio</p>
            <p>
              Antes de prosseguir para a finalização da compra, você deve
              adicionar alguns produtos ao carrinho
            </p>
            <p>
              Você encontrará muitas ofertas com vários tipos de lanche para
              saciar sua fome
            </p>
            <Link href="/">
              <ShoppingCart size={20} /> Retorne para loja
            </Link>
          </>
        ) : (
          <S.ProductContent>
            <S.ProductArea>
              {cart?.items.map((product) => (
                <S.Product key={product.name}>
                  <S.LeftArea>
                    <Image
                      src={product.image_url}
                      width={125}
                      height={125}
                      alt={product.name}
                    />
                    <div>
                      <p>{product.name}</p>
                      {product.observartion && (
                        <span>{product.observartion}</span>
                      )}
                      <div className="priceArea">
                        {product.price.toLocaleString('pt-BR', {
                          style: 'currency',
                          currency: 'BRL'
                        })}
                        <Counter
                          initialValue={product.quantity}
                          maxItems={5}
                          size="small"
                          key={product.name}
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
              ))}
            </S.ProductArea>
            <S.ProductResume>
              <S.ProductResumeDelivery>
                <h3>Local da Entrega</h3>
                <select name="address">
                  <option value="casa">casa</option>
                </select>
              </S.ProductResumeDelivery>
              <S.ProductResumeContent>
                <h3>Resumo da compra</h3>
                <div className="item">
                  <p>Sub-total</p>
                  <p>{cart.totalPrice}</p>
                </div>
                <div className="item">
                  <p>Frete</p>
                  <p>5</p>
                </div>
                <div className="total">
                  <h3>Total</h3>
                  <p>50,00</p>
                </div>
              </S.ProductResumeContent>
              <input type="submit" value="FINALIZAR COMPRA" />
            </S.ProductResume>
          </S.ProductContent>
        )}
      </S.Content>
    </S.Wrapper>
  );
}
