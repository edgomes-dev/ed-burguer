import { css, styled } from 'styled-components';

export const Wrapper = styled.span`
  ${({ theme }) => css`
    display: flex;
    background-color: ${theme.colors.gray.dark};
    padding: 15px;
    margin: 50px 0;
    gap: 2rem;

    img {
      border-radius: 20px;
      opacity: 0.8;
    }
  `}
`;

export const Content = styled.div`
  ${({ theme }) => css`
    display: flex;
    flex-direction: column;
    justify-content: center;
    color: ${theme.colors.title};

    span {
      font-weight: bolder;
    }
  `}
`;
