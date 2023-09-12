import { css, styled } from 'styled-components';

export const Wrapper = styled.label`
  input {
    display: none;
  }
`;

export const Content = styled.div`
  ${({ theme }) => css`
    display: flex;
    justify-content: space-between;
    margin: 16px 0;
    padding: 16px 0;
    border-bottom: 1px solid ${theme.colors.gray.medium};

    p {
      font-size: 12pt;
    }
  `}
`;

export const Price = styled.div`
  ${({ theme }) => css`
    display: flex;
    align-items: center;
    gap: 1.25rem;

    .item {
      font-size: 10pt;
      background-color: ${theme.colors.orange.main};
      padding: 3px;
      border-radius: 2px;
    }
  `}
`;
