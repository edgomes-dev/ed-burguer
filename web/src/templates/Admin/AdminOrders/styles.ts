import { css, styled } from 'styled-components';

export const Wrapper = styled.div`
  ${({ theme }) => css`
    h2 {
      color: ${theme.colors.title};
    }
  `}
`;

export const Cards = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 4rem;
`;

export const Card = styled.div`
  ${({ theme }) => css`
    display: flex;
    justify-content: center;
    align-items: center;
    gap: 1.25rem;
    width: 40rem;
    height: 20rem;
    padding: 1.25rem;
    background-color: ${theme.colors.white};
    border-radius: 5px;
    box-shadow: 1px 1px 1px 1px rgba(0, 0, 0, 0.4);

    .icon {
      width: 48px;
      height: 48px;
    }

    span {
      font-size: ${theme.font.sizes.huge};
    }

    p {
      font-size: ${theme.font.sizes.large};
    }
  `}
`;

export const Orders = styled.div``;
