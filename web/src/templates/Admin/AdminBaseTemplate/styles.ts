import { css, styled } from 'styled-components';

export const Wrapper = styled.div`
  ${({ theme }) => css`
    width: 100vw;
    height: 100vh;
    display: grid;
    background-color: ${theme.colors.white};
    grid-template-columns: 250px 1fr;
    grid-template-rows: 100px 1fr;
    grid-template-areas:
      'menuLeft menu'
      'menuLeft content';
  `}
`;

export const Content = styled.div`
  width: 100%;
  grid-area: content;
`;
