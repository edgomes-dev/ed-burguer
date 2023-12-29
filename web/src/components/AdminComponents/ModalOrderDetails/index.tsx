import * as S from './styles';
import {
  AiOutlineClose as CloseIcon,
  AiOutlineArrowRight as ArrowIcon
} from 'react-icons/ai';
import { RiDeleteBin7Fill as BinIcon } from 'react-icons/ri';
import { IOrder } from '../Table';

type ModalProductProps = {
  visible: boolean;
  closeModal: () => void;
  order: IOrder;
};

export function ModalOrderDetails({
  visible,
  closeModal,
  order
}: ModalProductProps) {
  return (
    <S.Wrapper visible={visible}>
      <S.Menu>
        <div>
          <p>Pedido #{order.id} * Feito às 14:13</p>
        </div>
        <CloseIcon
          onClick={closeModal}
          className="close"
          size={24}
          height={24}
        />
      </S.Menu>
      <S.Content>
        <S.Status>
          <h2>Status do Pedido</h2>

          <S.StatusIcons>
            <p>{order.status}</p>
            <div>
              <ArrowIcon />
              <BinIcon />
            </div>
          </S.StatusIcons>
        </S.Status>
        <S.Client>
          <h2>Resumo do Cliente</h2>
          <div>
            <p>Nome</p>
            <p>{order.user.name}</p>
          </div>
          <div>
            <p>Cpf</p>
            <p>{order.cpf}</p>
          </div>
          <div>
            <p>Forma de pagamento</p>
            <p>{order.payment}</p>
          </div>
        </S.Client>
        <S.Description>
          <h2>Resumo do pedido</h2>
          {order.productOrder.map((product) => (
            <S.DescriptionItem key={product.id + order.user.name}>
              <div>
                <p>{product.quantity}x</p>
                <p>{product.product.name}</p>
              </div>
              <p>{product.product.price}</p>
            </S.DescriptionItem>
          ))}
          <S.DescriptionItem>
            <div>
              <p>25x</p>
              <p>Subtotal</p>
            </div>
            <p>R$ 38,99</p>
          </S.DescriptionItem>
        </S.Description>
        <S.Address>
          <h2>Endereço de entrega</h2>
          {order.receiveType == 'REMOVAL' ? (
            <h1>Retirada</h1>
          ) : (
            <>
              <div>
                <p>Endereço</p>
                <p>
                  <p>
                    {order.addresses.street},{order.addresses.number},
                    {order.addresses.district.name}
                  </p>
                </p>
              </div>
              <div>
                <p>Frete</p>
                <p>{order.addresses.district.deliveryPrice}</p>
              </div>
            </>
          )}
        </S.Address>
        <S.Observation>
          <h2>Observação</h2>
          <p>Não possui observações</p>
        </S.Observation>
        <S.TotalPrice>Preço total</S.TotalPrice>
      </S.Content>
    </S.Wrapper>
  );
}
