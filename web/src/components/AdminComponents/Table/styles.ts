import { css, styled } from 'styled-components';

export const Wrapper = styled.table`
  width: 100%;
  margin-top: 3rem;
`;

export const Title = styled.div`
  ${({ theme }) => css`
    display: flex;
    align-items: center;
    justify-content: space-between;
    margin-bottom: 1rem;

    span {
      background-color: ${theme.colors.orange.main};
      padding: 5px 10px;
      border-radius: 8px;
      font-size: 15pt;
    }
  `}
`;

export const Table = styled.table`
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
    padding: 4px;
    text-align: center;
    width: 120px;
  }
`;
