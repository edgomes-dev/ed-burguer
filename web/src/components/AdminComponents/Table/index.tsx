import * as S from './styles';

export function Table() {
  return (
    <S.Wrapper>
      <thead>
        <tr>
          <td>id</td>
          <td>Name</td>
          <td>Payment</td>
          <td>Time remaining</td>
          <td>Type</td>
          <td>Status</td>
          <td>Total</td>
          <td>Action</td>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>1</td>
          <td>Brookly</td>
          <td>Cash</td>
          <td>13 min</td>
          <td>Delivery</td>
          <td>On The Way</td>
          <td>R$12,00</td>
          <td>:</td>
        </tr>
        <tr>
          <td>1</td>
          <td>Brookly</td>
          <td>Cash</td>
          <td>13 min</td>
          <td>Delivery</td>
          <td>On The Way</td>
          <td>R$12,00</td>
          <td>:</td>
        </tr>
        <tr>
          <td>1</td>
          <td>Brookly</td>
          <td>Cash</td>
          <td>13 min</td>
          <td>Delivery</td>
          <td>On The Way</td>
          <td>R$12,00</td>
          <td>:</td>
        </tr>
      </tbody>
    </S.Wrapper>
  );
}
