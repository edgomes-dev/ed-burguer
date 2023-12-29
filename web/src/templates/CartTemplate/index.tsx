import Link from 'next/link';
import * as S from './styles';
import {
  AiOutlineShoppingCart as ShoppingCart,
  AiOutlineArrowLeft as ArrowLeftIcon
} from 'react-icons/ai';
import Image from 'next/image';
import { Counter } from '@/components/Counter';
import { useSelector } from 'react-redux';
import { RootState } from '@/redux/store';
import { ItemsOrder } from '@/components/ItemsOrder';

export function CartTemplate() {
  const cart = useSelector((state: RootState) => state.cart);

  return (
    <S.Wrapper>
      <S.Menu>
        <Link href="/">
          <ArrowLeftIcon />
        </Link>
        <S.Button type="submit" value="Fazer Login" />
      </S.Menu>
      <S.Content>
        {cart.products.length === 0 ? (
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
              adicionar alguns produtos ao carrinho.
            </p>
            <p>
              Você encontrará muitas ofertas com vários tipos de lanche para
              saciar sua fome.
            </p>
            <Link href="/">
              <ShoppingCart size={20} /> Retorne para loja
            </Link>
          </>
        ) : (
          <S.ProductContent>
            <ItemsOrder cart={cart} />
            <S.ProductFinish>
              <div className="totalPrice">
                <h3>Total:</h3>
                <p>R$ 71,50</p>
              </div>
              <Link href="/cart/finish">
                <input type="submit" value="FINALIZAR COMPRA" />
              </Link>
              <div className="link">
                <Link href="/">
                  <p>Continuar comprando </p>
                  <ShoppingCart />
                </Link>
              </div>
            </S.ProductFinish>
          </S.ProductContent>
        )}
      </S.Content>
    </S.Wrapper>
  );
}
