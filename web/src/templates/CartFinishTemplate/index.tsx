import { ItemsOrder } from '@/components/ItemsOrder';
import * as S from './styles';

import {
  AiOutlineArrowLeft as ArrowLeftIcon,
  AiFillCreditCard as CardIcon
} from 'react-icons/ai';
import { HiMapPin as MapIcon } from 'react-icons/hi2';
import {
  GiMoneyStack as MoneyIcon,
  GiShoppingBag as BagIcon
} from 'react-icons/gi';
import { MdPix as PixIcon } from 'react-icons/md';
import { FaAddressCard as CpfIcon } from 'react-icons/fa';
import { useSelector } from 'react-redux';
import { RootState } from '@/redux/store';
import Image from 'next/image';
import { useState } from 'react';
import {
  DeliveryItems,
  IItem,
  ModalOrder,
  PaymentItems
} from '@/components/ModalOrder';
import Link from 'next/link';
import { IOrder } from '@/components/AdminComponents/Table';
import { api } from '@/utils/axios';

interface IProductOrders {
  product_id: number;
  observation?: string;
  quantity: number;
}

interface IOrderFinish {
  user_id: number;
  address_id: number;
  payment: number;
  receive_type: number;
  cpf?: string;
  price: number;
  products: IProductOrders[];
}

export function CartFinishTemplate() {
  const cart = useSelector((state: RootState) => state.cart);

  const [deliverySection, setDeliverySection] = useState<
    DeliveryItems | PaymentItems
  >(DeliveryItems.Delivery);
  const [deliveryVisible, setDeliveryVisible] = useState(false);

  const [addressVisible, setAddressVisible] = useState(false);

  const [paymentSection, setPaymentSection] = useState<
    DeliveryItems | PaymentItems
  >(PaymentItems.Money);
  const [paymentVisible, setPaymentVisible] = useState(false);

  const deliveryItems: IItem[] = [
    {
      icon: (
        <Image
          src={'/img/motocycle.svg'}
          width={60}
          height={60}
          alt="Delivery"
        />
      ),
      text: 'Delivery',
      section: DeliveryItems.Delivery
    },
    {
      icon: <BagIcon size={60} color="#DB790F" />,
      text: 'Retirada',
      section: DeliveryItems.Removal
    }
  ];

  const addressItems: IItem[] = [
    {
      titleAddress: 'Casa',
      text: 'Rua Arábia Saudita, 22A, próximo a igreja Deus é fiel, Pau Amarelo'
    },
    {
      titleAddress: 'Trabalho',
      text: 'Rua Cavaleiro, 37, Beira Mar'
    }
  ];

  const paymentItems: IItem[] = [
    {
      icon: <MoneyIcon size={60} color="#118c4f" />,
      text: 'Dinheiro',
      section: PaymentItems.Money
    },
    {
      icon: <PixIcon size={60} color="#1E90FF" />,
      text: 'Pix',
      section: PaymentItems.Pix
    },
    {
      icon: <CardIcon size={60} />,
      text: 'Cartão',
      section: PaymentItems.Card
    }
  ];

  function handleSubmit() {
    let products: IProductOrders[] = [];
    cart.products.map((product) =>
      products.push({
        product_id: product.product_id,
        observation: product.observartion,
        quantity: product.quantity
      })
    );

    const data: IOrderFinish = {
      user_id: 1,
      address_id: 1,
      payment: paymentSection + 1,
      receive_type: deliverySection + 1,
      price: cart.price, // preciso somar tudo e colocar o preço do frete
      products: products
    };

    api
      .post('orders', data)
      .then((res) => console.log(res.data))
      .catch((e) => console.log(e));
  }

  return (
    <>
      <S.Wrapper>
        <S.Menu>
          <Link href="/">
            <ArrowLeftIcon color="white" />
          </Link>
          <p>Finalizar</p>
          <p>teste</p>
        </S.Menu>
        <S.Main>
          <ItemsOrder cart={cart} />
          <S.Delivery>
            <h3>Tipo de Entrega</h3>
            <S.Content>
              {deliverySection === DeliveryItems.Delivery ? (
                <S.Icon>
                  <Image
                    src={'/img/motocycle.svg'}
                    width={60}
                    height={60}
                    alt="Delivery"
                  />
                  <p>Delivery</p>
                </S.Icon>
              ) : (
                <S.Icon>
                  <BagIcon size={60} color="#DB790F" />
                  <p>Retirada</p>
                </S.Icon>
              )}
              <S.Button onClick={() => setDeliveryVisible(true)}>
                ALTERAR
              </S.Button>
            </S.Content>
          </S.Delivery>
          <S.Address>
            <h3>Entregar em</h3>
            <S.Content>
              <S.Icon>
                <MapIcon size={60} color="#DB790F" />
                <div>
                  <p>Selecione um endereço - Casa</p>
                  <span>
                    Rua Arábia Saudita, 22A, próximo a igreja Deus é fiel, Pau
                    Amarelo.
                  </span>
                </div>
              </S.Icon>
              <S.Button onClick={() => setAddressVisible(true)}>
                ALTERAR
              </S.Button>
            </S.Content>
          </S.Address>
          <S.Payment>
            <h3>Tipo de Pagamento</h3>
            <S.Content>
              {paymentSection === PaymentItems.Money ? (
                <S.Icon>
                  <MoneyIcon size={60} color="#118c4f" />
                  <p>Precisa de troco ?</p>
                </S.Icon>
              ) : paymentSection === PaymentItems.Pix ? (
                <S.Icon>
                  <PixIcon size={60} color="#1E90FF" />
                  <p>Pix</p>
                </S.Icon>
              ) : (
                <S.Icon>
                  <CardIcon size={60} />
                  <p>Cartão</p>
                </S.Icon>
              )}
              <S.Button onClick={() => setPaymentVisible(true)}>
                ALTERAR
              </S.Button>
            </S.Content>
          </S.Payment>
          <S.Cpf>
            <h3>CPF na nota</h3>
            <S.Icon>
              <CpfIcon size={60} />
              <div>
                <p>CPF</p>
                <p>Clique aqui para adicionar</p>
              </div>
            </S.Icon>
          </S.Cpf>
          <S.Observation>
            <h3>Observações</h3>
            <textarea
              name=""
              id=""
              rows={4}
              placeholder="EX: Campainha quebrada, casa ao fundo, etc"
            />
          </S.Observation>
          <S.Resume>
            <h3>Resumo</h3>
            <S.ResumeItem>
              <p>subtotal</p>
              <p>25,00</p>
            </S.ResumeItem>
            <S.ResumeItem>
              <p>entrega</p>
              <p>3,00</p>
            </S.ResumeItem>
            <S.ResumeItem>
              <p>total</p>
              <p>28,00</p>
            </S.ResumeItem>
            <div className="button">
              <button onClick={handleSubmit}>Finalizar</button>
            </div>
          </S.Resume>
        </S.Main>
      </S.Wrapper>
      <ModalOrder
        visible={deliveryVisible}
        items={deliveryItems}
        closeModal={() => setDeliveryVisible(false)}
        changeSection={(section: DeliveryItems | PaymentItems) => {
          setDeliverySection(section);
          setDeliveryVisible(false);
        }}
      />
      <ModalOrder
        visible={addressVisible}
        items={addressItems}
        closeModal={() => setAddressVisible(false)}
      />
      <ModalOrder
        visible={paymentVisible}
        items={paymentItems}
        closeModal={() => setPaymentVisible(false)}
        changeSection={(section: DeliveryItems | PaymentItems) => {
          setPaymentSection(section);
          setPaymentVisible(false);
        }}
      />
    </>
  );
}
