import Image from 'next/image';
import { SetStateAction, useEffect } from 'react';
import * as S from './styles';
import { AiOutlineClose as CloseIcon } from 'react-icons/ai';
import { GiShoppingBag as BagIcon } from 'react-icons/gi';

export enum DeliveryItems {
  Delivery,
  Removal
}

export enum PaymentItems {
  Money,
  Pix,
  Card
}

export interface IItem {
  icon?: JSX.Element;
  titleAddress?: string;
  text: string;
  section?: DeliveryItems | PaymentItems;
}

interface IProps {
  visible: boolean;
  items: IItem[];
  closeModal: () => void;
  changeSection?: (section: DeliveryItems | PaymentItems) => void;
}

export function ModalOrder({
  visible,
  items,
  closeModal,
  changeSection
}: IProps) {
  useEffect(() => {
    if (visible) {
      document.body.classList.toggle('modal-open', visible);
    } else {
      document.body.classList.remove('modal-open');
    }
  }, [visible]);

  if (!!changeSection) {
    return (
      <S.Wrapper visible={visible}>
        <S.Menu>
          <CloseIcon onClick={closeModal} size={24} />
          <p>Selecione a entrega</p>
        </S.Menu>
        <S.Content>
          {items.map((element) => (
            <S.Item
              key={element.text}
              onClick={() => changeSection(element.section!)}
            >
              {element.icon}
              {element.text}
            </S.Item>
          ))}
        </S.Content>
      </S.Wrapper>
    );
  } else {
    return (
      <S.Wrapper visible={visible}>
        <S.Menu>
          <CloseIcon onClick={closeModal} size={24} />
          <p>Selecione a entrega</p>
        </S.Menu>
        <S.Content>
          {items.map((element) => (
            <S.Item key={element.text} className="address">
              <p>{element.titleAddress}</p>
              <p>{element.text}</p>
            </S.Item>
          ))}
        </S.Content>
      </S.Wrapper>
    );
  }
}
