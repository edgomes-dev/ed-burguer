import * as S from './styles';

import { RiShoppingBag2Fill as OrdersIcon } from 'react-icons/ri';
import { BsClockFill as PendingIcon } from 'react-icons/bs';
import { GiFullMotorcycleHelmet as DispatchIcon } from 'react-icons/gi';

export function AdminOrderListTemplate() {
  return (
    <S.Wrapper>
      <h3>All Orders 50</h3>
      <S.Manager>
        <S.SelectDate>
          <h4>Selecione o intervalo da data</h4>
          <S.AreaData>
            <div>
              <p>Tipo de status</p>
              <select placeholder="Tipo de status">
                <option>Todos</option>
                <option>Finalizados</option>
                <option>Espera</option>
                <option>Preparo</option>
                <option>Entrega</option>
                <option>Retirada</option>
                <option>Cancelados</option>
                <option>Falha na entrega</option>
              </select>
            </div>
            <div>
              <p>Data inicial</p>
              <input type="date" />
            </div>
            <div>
              <p>Data final</p>
              <input type="date" />
            </div>
            <div>
              <p className="hidden">auxiliar</p>
              <button className="clearButton">Limpar</button>
            </div>
            <div>
              <p className="hidden">auxiliar</p>
              <button className="showButton">Exibir data</button>
            </div>
          </S.AreaData>
        </S.SelectDate>
        <S.Cards>
          <S.TopCards>
            <S.CardMini>
              <div>
                <OrdersIcon size={45} className="icon" />
                <p>Pedidos Finalizados</p>
              </div>
              <span>47</span>
            </S.CardMini>
            <S.CardMini>
              <div>
                <PendingIcon size={45} className="icon" />
                <p>Pedidos em Espera</p>
              </div>
              <span>56</span>
            </S.CardMini>
            <S.CardMini>
              <div>
                <PendingIcon size={45} className="icon" />
                <p>Pedidos em Preparo</p>
              </div>
              <span>56</span>
            </S.CardMini>
            <S.CardMini>
              <div>
                <DispatchIcon size={45} className="icon" />
                <p>Em entrega</p>
              </div>
              <span>26</span>
            </S.CardMini>
          </S.TopCards>
          <S.BottomCards>
            <S.CardMini>
              <div>
                <DispatchIcon size={45} className="icon" />
                <p>Aguardando Retirada</p>
              </div>
              <span>26</span>
            </S.CardMini>
            <S.CardMini>
              <div>
                <DispatchIcon size={45} className="icon" />
                <p>Cancelados</p>
              </div>
              <span>26</span>
            </S.CardMini>
            <S.CardMini>
              <div>
                <DispatchIcon size={45} className="icon" />
                <p>Falha na entrega</p>
              </div>
              <span>26</span>
            </S.CardMini>
          </S.BottomCards>
        </S.Cards>
      </S.Manager>
      <S.Table>
        <thead>
          <tr>
            <td>SL</td>
            <td>Order ID</td>
            <td>Horário do Pedido</td>
            <td>Cliente</td>
            <td>Preço</td>
            <td>Status</td>
            <td>Tipo de entrega</td>
            <td>Ações</td>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>1</td>
            <td>100108</td>
            <td>07 Nov 2023 06:59 PM</td>
            <td>Mikaelli</td>
            <td>R$ 130,00</td>
            <td>Confirmado</td>
            <td>Delivery</td>
            <td>Ações</td>
          </tr>
        </tbody>
      </S.Table>
    </S.Wrapper>
  );
}
