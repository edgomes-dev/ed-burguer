import * as S from './styles';

import { Chart as Chartjs, ArcElement, Tooltip, Legend } from 'chart.js';
import { Pie } from 'react-chartjs-2';

import { RiShoppingBag2Fill as OrdersIcon } from 'react-icons/ri';
import { BsClockFill as PendingIcon } from 'react-icons/bs';
import { GiFullMotorcycleHelmet as DispatchIcon } from 'react-icons/gi';
import Image from 'next/image';

Chartjs.register(ArcElement, Tooltip, Legend);

function PieChart() {
  const data = {
    labels: [
      'Finalizados',
      'espera',
      'Preparo',
      'Entrega',
      'Retirada',
      'Cancelados',
      'Falha na Entrega'
    ],
    datasets: [
      {
        label: 'Pedidos',
        data: [12, 19, 3, 5, 2, 3, 2],
        backgroundColor: 'rgba(75, 192, 192, 0.2)',
        borderColor: 'rgba(75, 192, 192, 1)',
        borderWidth: 1
      }
    ]
  };

  const options = {
    plugins: {
      legend: {
        display: false
      }
    }
  };

  return (
    <S.RightArea className="column">
      <h3>Estátistica dos Pedidos</h3>
      <div>
        <ul>
          <li>Finalizados</li>
          <li>Espera</li>
          <li>Preparo</li>
          <li>Entrega</li>
          <li>Retirada</li>
          <li>Cancelados</li>
          <li>Falha na entrega</li>
        </ul>
        <div className="graph">
          <Pie data={data} options={options} key="pie-chart" />
        </div>
      </div>
    </S.RightArea>
  );
}

export function AdminIndexTemplate() {
  return (
    <S.Wrapper>
      <h2>Seja bem vindo, Edson Gomes !</h2>
      <p>monitore seu negócio !</p>
      <S.Cards>
        <S.TopCards>
          <S.Card>
            <div>
              <OrdersIcon size={45} className="icon" />
              <span>47</span>
            </div>
            <p>Pedidos Finalizados</p>
          </S.Card>
          <S.Card>
            <div>
              <PendingIcon size={45} className="icon" />
              <span>56</span>
            </div>
            <p>Pedidos em Espera</p>
          </S.Card>
          <S.Card>
            <div>
              <PendingIcon size={45} className="icon" />
              <span>56</span>
            </div>
            <p>Pedidos em Preparo</p>
          </S.Card>
          <S.Card>
            <div>
              <DispatchIcon size={45} className="icon" />
              <span>26</span>
            </div>
            <p>Em entrega</p>
          </S.Card>
        </S.TopCards>
        <S.BottomCards>
          <S.CardMini>
            <div>
              <DispatchIcon size={45} className="icon" />
              <span>26</span>
            </div>
            <p>Aguardando Retirada</p>
          </S.CardMini>
          <S.CardMini>
            <div>
              <DispatchIcon size={45} className="icon" />
              <span>26</span>
            </div>
            <p>Cancelados</p>
          </S.CardMini>
          <S.CardMini>
            <div>
              <DispatchIcon size={45} className="icon" />
              <span>26</span>
            </div>
            <p>Falha na entrega</p>
          </S.CardMini>
        </S.BottomCards>
      </S.Cards>
      <S.ManagerArea>
        <S.LeftArea className="column">
          <h3>Quadro de funcionários</h3>
          <S.StaffTable>
            <S.StaffItemTable>
              <div className="information">
                <Image
                  src={'/img/29-11-2023-08-58-01hamburguer-piloto.jpg'}
                  alt={'Hambúrguer Piloto'}
                  width={80}
                  height={80}
                />
                <div>
                  <p>Mikaelli Silva</p>
                  <span>Gerente</span>
                </div>
              </div>
              <span>17:45 PM</span>
            </S.StaffItemTable>
            <S.StaffItemTable>
              <div className="information">
                <Image
                  src={'/img/29-11-2023-08-58-01hamburguer-piloto.jpg'}
                  alt={'Hambúrguer Piloto'}
                  width={80}
                  height={80}
                />
                <div>
                  <p>Julio Roberto</p>
                  <span>Motoboy</span>
                </div>
              </div>
              <span>17:45 PM</span>
            </S.StaffItemTable>
            <S.StaffItemTable>
              <div className="information">
                <Image
                  src={'/img/29-11-2023-08-58-01hamburguer-piloto.jpg'}
                  alt={'Hambúrguer Piloto'}
                  width={80}
                  height={80}
                />
                <div>
                  <p>Edson Gomes</p>
                  <span>Dono</span>
                </div>
              </div>
              <span>17:45 PM</span>
            </S.StaffItemTable>
            <S.StaffItemTable>
              <div className="information">
                <Image
                  src={'/img/29-11-2023-08-58-01hamburguer-piloto.jpg'}
                  alt={'Hambúrguer Piloto'}
                  width={80}
                  height={80}
                />
                <div>
                  <p>Marina Silva</p>
                  <span>Atendente</span>
                </div>
              </div>
              <span>17:45 PM</span>
            </S.StaffItemTable>
            <S.StaffItemTable>
              <div className="information">
                <Image
                  src={'/img/29-11-2023-08-58-01hamburguer-piloto.jpg'}
                  alt={'Hambúrguer Piloto'}
                  width={80}
                  height={80}
                />
                <div>
                  <p>David Borges</p>
                  <span>Chapeiro</span>
                </div>
              </div>
              <span>17:45 PM</span>
            </S.StaffItemTable>
            <S.StaffItemTable>
              <div className="information">
                <Image
                  src={'/img/29-11-2023-08-58-01hamburguer-piloto.jpg'}
                  alt={'Hambúrguer Piloto'}
                  width={80}
                  height={80}
                />
                <div>
                  <p>Bruno Lopes</p>
                  <span>Garçom</span>
                </div>
              </div>
              <span>17:45 PM</span>
            </S.StaffItemTable>
          </S.StaffTable>
        </S.LeftArea>
        <S.MidArea className="column">
          <h3>Quadro de Avisos</h3>
          <S.NoticeArea>
            <S.NoticeElement>Batata Frita acabou</S.NoticeElement>
          </S.NoticeArea>
        </S.MidArea>
        <PieChart />
      </S.ManagerArea>
      <S.Seller>
        <S.Collum>
          <h3>Mais vendidos do dia</h3>
          <S.Table>
            <S.ItemTable>
              <div>
                <Image
                  src={'/img/29-11-2023-08-58-01hamburguer-piloto.jpg'}
                  alt={'Hambúrguer Piloto'}
                  width={54}
                  height={54}
                />
                <p>Hambúrguer Piloto</p>
              </div>
              20
            </S.ItemTable>
            <S.ItemTable>
              <div>
                <Image
                  src={'/img/30-11-2023-21-40-13pizza-chicken.jpg'}
                  alt={'Pizza de Frango'}
                  width={54}
                  height={54}
                />
                <p>Pizza de Frango</p>
              </div>
              20
            </S.ItemTable>
            <S.ItemTable>
              <div>
                <Image
                  src={'/img/04-08-2023-17-30-03coca-cola-2L.jpeg'}
                  alt={'Coca Cola (2 Litros)'}
                  width={54}
                  height={54}
                />
                <p>Coca Cola (2 Litros)</p>
              </div>
              20
            </S.ItemTable>
            <S.ItemTable>
              <div>
                <Image
                  src={'/img/28-11-2023-17-51-59hotdog-amoroso.jpg'}
                  alt={'Cachorro Quente Amoroso'}
                  width={54}
                  height={54}
                />
                <p>Cachorro Quente Amoroso</p>
              </div>
              20
            </S.ItemTable>
            <S.ItemTable>
              <div>
                <Image
                  src={'/img/29-11-2023-08-59-04hamburguer-cuidadoso.jpg'}
                  alt={'Hambúrguer Cuidadoso'}
                  width={54}
                  height={54}
                />
                <p>Hambúrguer Cuidadoso</p>
              </div>
              20
            </S.ItemTable>
            <S.ItemTable>
              <div>
                <Image
                  src={'/img/04-08-2023-17-28-09acai-amoroso.jpg'}
                  alt={'Açai Amoroso'}
                  width={54}
                  height={54}
                />
                <p>Açai Amoroso</p>
              </div>
              20
            </S.ItemTable>
          </S.Table>
        </S.Collum>
        <S.Collum>
          <h3>Melhores avaliados</h3>
          <S.Table>
            <S.ItemTable>
              <div>
                <Image
                  src={'/img/29-11-2023-09-00-20hamburguer-verdadeiro.jpg'}
                  alt={'Hambúrguer Verdadeiro'}
                  width={54}
                  height={54}
                />
                <p>Hambúrguer Verdadeiro</p>
              </div>
              20
            </S.ItemTable>
            <S.ItemTable>
              <div>
                <Image
                  src={'/img/28-11-2023-17-52-15hotdog-verdadeiro.jpg'}
                  alt={'Cachorro Quente Verdadeiro'}
                  width={54}
                  height={54}
                />
                <p>Cachorro Quente Verdadeiro</p>
              </div>
              20
            </S.ItemTable>
            <S.ItemTable>
              <div>
                <Image
                  src={'/img/30-11-2023-21-40-13pizza-chicken.jpg'}
                  alt={'Pizza de Frango'}
                  width={54}
                  height={54}
                />
                <p>Pizza de Frango</p>
              </div>
              20
            </S.ItemTable>
            <S.ItemTable>
              <div>
                <Image
                  src={'/img/28-11-2023-17-51-59hotdog-amoroso.jpg'}
                  alt={'Cachorro Quente Amoroso'}
                  width={54}
                  height={54}
                />
                <p>Cachorro Quente Amoroso</p>
              </div>
              20
            </S.ItemTable>
            <S.ItemTable>
              <div>
                <Image
                  src={'/img/29-11-2023-08-59-04hamburguer-cuidadoso.jpg'}
                  alt={'Hambúrguer Cuidadoso'}
                  width={54}
                  height={54}
                />
                <p>Hambúrguer Cuidadoso</p>
              </div>
              20
            </S.ItemTable>
            <S.ItemTable>
              <div>
                <Image
                  src={'/img/01-12-2023-08-45-29chicken-pie.jpeg'}
                  alt={'Empada de Frango'}
                  width={54}
                  height={54}
                />
                <p>Empada de Frango</p>
              </div>
              20
            </S.ItemTable>
          </S.Table>
        </S.Collum>
        <S.Collum>
          <h3>Clientes com mais pedidos</h3>
          <S.Table>
            <S.ItemTable>
              <div>
                <Image
                  src={'/img/undefined.jpg'}
                  alt={'Mikaelli'}
                  width={54}
                  height={54}
                />
                <p>Mikaelli</p>
              </div>
              20
            </S.ItemTable>
            <S.ItemTable>
              <div>
                <Image
                  src={'/img/undefined.jpg'}
                  alt={'Roberta'}
                  width={54}
                  height={54}
                />
                <p>Roberta</p>
              </div>
              20
            </S.ItemTable>
            <S.ItemTable>
              <div>
                <Image
                  src={'/img/undefined.jpg'}
                  alt={'Cristian'}
                  width={54}
                  height={54}
                />
                <p>Cristian</p>
              </div>
              20
            </S.ItemTable>
            <S.ItemTable>
              <div>
                <Image
                  src={'/img/undefined.jpg'}
                  alt={'Rosineide'}
                  width={54}
                  height={54}
                />
                <p>Rosineide</p>
              </div>
              20
            </S.ItemTable>
            <S.ItemTable>
              <div>
                <Image
                  src={'/img/undefined.jpg'}
                  alt={'Micael'}
                  width={54}
                  height={54}
                />
                <p>Micael</p>
              </div>
              20
            </S.ItemTable>
            <S.ItemTable>
              <div>
                <Image
                  src={'/img/undefined.jpg'}
                  alt={'Ed'}
                  width={54}
                  height={54}
                />
                <p>Ed</p>
              </div>
              20
            </S.ItemTable>
          </S.Table>
        </S.Collum>
      </S.Seller>
    </S.Wrapper>
  );
}

/* labels: [
  'Janeiro',
  'Fevereiro',
  'Março',
  'Abril',
  'Maio',
  'Junho',
  'Julho',
  'Agosto',
  'Setembro',
  'Outubro',
  'Novembro',
  'Dezembro'
  ]*/
