import { css, styled } from 'styled-components';

export const Wrapper = styled.nav`
  ${({ theme }) => css`
    background-color: ${theme.colors.text};
    height: 6rem;

    a {
      text-decoration: none;
      color: white;
    }

    ul {
      display: flex;
      height: 100%;
      justify-content: space-around;
      align-items: center;
      list-style: none;

      li {
        font-size: 1.4em;
        color: ${theme.colors.white};
      }
    }
  `}
`;

export const LeftArea = styled.div`
  display: flex;
  align-items: center;
  gap: 8px;
  font-size: 18pt;
  color: white;
`;

export const RightArea = styled.div`
  display: flex;
  gap: 1.5rem;
`;

export const Cart = styled.li`
  display: flex;
  align-items: center;
  gap: 1.5rem;
  height: 24px;

  span {
    font-size: 80%;
  }
`;

type AccountProps = {
  account: boolean;
};

export const Account = styled.li<AccountProps>`
  position: relative;

  ${({ theme, account }) => css`
    ul {
      position: absolute;
      top: 40px;
      right: 0;
      z-index: 1;
      background-color: ${theme.colors.title};
      width: 20rem;
      display: ${account ? 'none' : 'flex'};
      flex-direction: column;
      align-items: flex-start;

      li {
        font-size: 0.8em;

        a {
          color: ${theme.colors.white};
        }
      }
    }
  `}
`;
