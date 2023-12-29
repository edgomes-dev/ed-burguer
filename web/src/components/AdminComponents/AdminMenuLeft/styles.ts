import { css, styled } from 'styled-components';

export const Wrapper = styled.aside`
  ${({ theme }) => css`
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-between;
    background-color: ${theme.colors.gray.dark};
    padding: 4rem;
    width: 120px;
    height: 100%;
    margin-top: 60px;
    position: fixed;

    ul {
      li {
        list-style: none;

        a {
          text-decoration: none;
          color: ${theme.colors.gray.lighther};
          font-size: 1.3em;

          display: flex;
          flex-direction: column;
          justify-content: center;
          align-items: center;
        }
      }
    }
  `}
`;

export const TopArea = styled.ul``;

export const BottomArea = styled.ul`
  margin-bottom: 5rem;
`;
