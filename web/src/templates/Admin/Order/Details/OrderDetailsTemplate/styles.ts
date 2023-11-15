import styled from 'styled-components';

export const Wrapper = styled.div`
  display: grid;
  margin: 0px 100px 0px 100px;
  grid-template-columns: 2fr 1fr;
  gap: 2rem;
`;

export const LeftArea = styled.div`
  :first-child {
    margin-bottom: 2rem;
  }
`;

export const Item = styled.div`
  display: flex;
  justify-content: space-between;
`;

export const ItemsSummary = styled.div`
  width: 100%;
  border-collapse: collapse;

  tr {
    border: 1px solid black;

    &:hover:ntn-child(1n + 2) {
      background-color: #085f63;
      color: #fff;
    }
  }

  th {
    font-weight: bold;
  }

  th,
  td {
    padding: 10px;
    text-align: center;
    width: 120px;
  }
`;

export const CustomerOrderDetails = styled.div`
  border: 1px solid black;
  margin-top: 4rem;
  padding: 2rem;
`;

export const RightArea = styled.div``;
