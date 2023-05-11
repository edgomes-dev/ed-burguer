import { css, styled } from 'styled-components';

export const Wrapper = styled.nav`
  ${({ theme }) => css`
    background-color: ${theme.colors.secondary};
    height: 6rem;

    ul {
      display: flex;
      justify-content: space-around;
      list-style: none;
    }
  `}
`;
