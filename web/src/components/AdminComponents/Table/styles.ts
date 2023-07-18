import { styled } from 'styled-components';

export const Wrapper = styled.table`
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
