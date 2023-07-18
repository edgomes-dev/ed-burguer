import { Table } from '@/components/AdminComponents/Table';
import * as S from './styles';

export function AdminOrderHistoryTemplate() {
  return (
    <S.Wrapper>
      <h2>Order History</h2>
      <S.Menu>
        <nav>
          <ul>
            <li>All Order</li>
            <li>Summary</li>
            <li>Completed</li>
            <li>Cancelled</li>
          </ul>
        </nav>
        <div>
          <input type="date" />
          To
          <input type="date" />
        </div>
      </S.Menu>
      <Table />
    </S.Wrapper>
  );
}
