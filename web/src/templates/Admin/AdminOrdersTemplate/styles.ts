import { css, styled } from 'styled-components';

export const Wrapper = styled.div`
  ${({ theme }) => css`
    width: 80%;
    margin: 0 auto;

    h2 {
      color: ${theme.colors.title};
    }
  `}
`;

export const Cards = styled.div`
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 2.5rem;
`;

export const Card = styled.div`
  ${({ theme }) => css`
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    background-color: ${theme.colors.white};
    border-radius: 5px;
    box-shadow: 1px 1px 1px 1px rgba(0, 0, 0, 0.4);
    padding: 30px 0;

    div {
      display: flex;
      align-items: center;
      gap: 5px;
    }

    span {
      font-size: 28pt;
    }

    p {
      font-size: ${theme.font.sizes.large};
    }
  `}
`;

export const Orders = styled.div`
  padding-bottom: 6rem;
`;
