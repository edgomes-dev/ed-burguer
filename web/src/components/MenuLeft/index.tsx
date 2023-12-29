import Image from 'next/image';
import { MenuLeftItem } from '../MenuLeftItem';
import { FaMotorcycle as MotoIcon } from 'react-icons/fa';
import {
  GiShoppingBag as BagIcon,
  GiTakeMyMoney as MoneyIcon
} from 'react-icons/gi';
import {
  AiFillCreditCard as CardIcon,
  AiOutlineClose as CloseIcon
} from 'react-icons/ai';
import * as S from './styles';

type MenuLeftProps = {
  visible: boolean;
  closeMenu: () => void;
};
export function MenuLeft({ visible, closeMenu }: MenuLeftProps) {
  const date = new Date().getDay();

  return (
    <S.Wrapper visible={visible}>
      <S.Content>
        <CloseIcon onClick={(e) => closeMenu()} className="closeIcon" />
        <Image
          src="/img/edburguer-logo.png"
          width={150}
          height={150}
          alt="Logo"
        />
        <MenuLeftItem
          title="Av. Antônio Cabral de Souza, 6675, N. Sra.da Conceição, Paulista PE"
          icon={false}
        />
        <MenuLeftItem title="Hórarios de atendimento">
          <S.HourItem className={date === 0 ? 'active' : ''}>
            <p>Domingo:</p>
            <p>18:00 - 00:00</p>
          </S.HourItem>
          <S.HourItem className={date === 1 ? 'active' : ''}>
            <p>Segunda-Feira:</p>
            <p>Fechado</p>
          </S.HourItem>
          <S.HourItem className={date === 2 ? 'active' : ''}>
            <p>Terça-Feira:</p>
            <p>18:00 - 00:00</p>
          </S.HourItem>
          <S.HourItem className={date === 3 ? 'active' : ''}>
            <p>Quarta-Feira:</p>
            <p>18:00 - 00:00</p>
          </S.HourItem>
          <S.HourItem className={date === 4 ? 'active' : ''}>
            <p>Quinta-Feira:</p>
            <p>18:00 - 00:00</p>
          </S.HourItem>
          <S.HourItem className={date === 5 ? 'active' : ''}>
            <p>Sexta-Feira:</p>
            <p>18:00 - 00:00</p>
          </S.HourItem>
          <S.HourItem className={date === 6 ? 'active' : ''}>
            <p>Sábado:</p>
            <p>18:00 - 00:00</p>
          </S.HourItem>
        </MenuLeftItem>
        <MenuLeftItem title="tipos de entrega">
          <S.IconContainer>
            <MotoIcon />
            <p>Delivery</p>
          </S.IconContainer>
          <S.IconContainer>
            <BagIcon />
            <p>Retirada</p>
          </S.IconContainer>
        </MenuLeftItem>
        <MenuLeftItem title="formas de pagamento">
          <S.IconContainer>
            <CardIcon />
            <p>Cartão de Crédito</p>
          </S.IconContainer>
          <S.IconContainer>
            <CardIcon />
            <p>Cartão de Débito</p>
          </S.IconContainer>
          <S.IconContainer>
            <MoneyIcon />
            <p>Dinheiro</p>
          </S.IconContainer>
        </MenuLeftItem>
        <MenuLeftItem title="Região de entrega">
          <p>Pau Amarelo</p>
          <p>Beira Mar</p>
          <p>Conceição</p>
        </MenuLeftItem>
      </S.Content>
      <S.Overlay></S.Overlay>
    </S.Wrapper>
  );
}
