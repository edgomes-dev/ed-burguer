import { css, styled } from 'styled-components';

type WrapperProps = {
  required: boolean;
};
export const Wrapper = styled.div<WrapperProps>`
  ${({ theme, required }) => css`
    input {
      display: ${required ? 'block' : 'none'};
    }
  `}
`;

export const Content = styled.div`
  ${({ theme }) => css`
    display: flex;
    justify-content: space-between;
    margin: 16px 0;
    padding: 16px 0;
    border-bottom: 1px solid ${theme.colors.gray.lighther};

    p {
      font-size: 12pt;
    }

    input[type='radio'] {
      accent-color: ${theme.colors.orange.main};
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
