import { css, styled } from 'styled-components';

export const Wrapper = styled.div`
  ${({ theme }) => css`
    width: 100%;
    display: flex;
    flex-direction: column;
    gap: 12rem;
    align-items: center;
    background-color: ${theme.colors.white};
    padding: 5rem;
    grid-area: menuLeft;
  `}
`;

export const Content = styled.nav`
  ${({ theme }) => css`
    ul {
      li {
        list-style: none;

        a {
          text-decoration: none;
          color: ${theme.colors.gray.light};
          font-size: 1.3em;
        }
      }
    }
  `}
`;
