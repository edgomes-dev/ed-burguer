import * as S from './styles';

export function OrderDetailsTemplate() {
  return (
    <S.Wrapper>
      <S.LeftArea>
        <h2>Número do Pedido #256894</h2>
        <S.ItemsSummary>
          <thead>
            <tr>
              <td>Resumo dos itens</td>
              <td>QTD</td>
              <td>Preço</td>
              <td>Preço Total</td>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>Açai Simples</td>
              <td>3</td>
              <td>7</td>
              <td>21</td>
            </tr>
            <tr>
              <td>Açai Amoroso</td>
              <td>1</td>
              <td>15</td>
              <td>15</td>
            </tr>
            <tr>
              <td>Coca Cola</td>
              <td>2</td>
              <td>6</td>
              <td>12</td>
            </tr>
          </tbody>
        </S.ItemsSummary>
        <S.CustomerOrderDetails>
          <h2>Detalhes do cliente e pedido</h2>
          <S.Item>
            <h3>Nome do cliente</h3>
            <p>Harun Libbli</p>
          </S.Item>
          <S.Item>
            <h3>Número do telefone</h3>
            <p>79188881829</p>
          </S.Item>
          <S.Item>
            <h3>Tipo</h3>
            <p>Entrega</p>
          </S.Item>
          <S.Item>
            <h3>Observação</h3>
            <p>N/A</p>
          </S.Item>
        </S.CustomerOrderDetails>
      </S.LeftArea>
      <S.RightArea>
        <div>
          <h2>Detalhes do entregador</h2>
          <p>Robart Suvent Track</p>
        </div>
        <div>
          <h2>Resumo do pedido</h2>
          <S.Item>
            <h3>Data do pedido</h3>
            <p>Sun, May 7, 2021</p>
          </S.Item>
          <S.Item>
            <h3>Hora do pedido</h3>
            <p>06:24 AM</p>
          </S.Item>
          <S.Item>
            <h3>Subtotal</h3>
            <p>R$ 375,00</p>
          </S.Item>
          <S.Item>
            <h3>Taxa de entrega</h3>
            <p>R$ 0,00</p>
          </S.Item>
        </div>
        <div>
          <h3>Total</h3>
          <p>R$ 375,00</p>
        </div>
        <div>
          <h2>Endereço de Entrega</h2>
          <div>
            <h3>Endereço</h3>
            <p>14 Anglesey Road</p>
          </div>
          <div>
            <h3>Rua</h3>
            <p>James Count</p>
          </div>
          <div>
            <h3>Cidade</h3>
            <p>Anglesey Road</p>
          </div>
          <div>
            <h3>Complemento</h3>
            <p>Anglesey Road</p>
          </div>
          <div>
            <h3>CEP</h3>
            <p>En3 4ny</p>
          </div>
        </div>
      </S.RightArea>
    </S.Wrapper>
  );
}
