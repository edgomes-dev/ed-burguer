import { css, styled } from 'styled-components';

export const Wrapper = styled.nav`
  ${({ theme }) => css`
    background-color: ${theme.colors.gray.light};
    height: 10rem;

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

      @media (min-width: 500px) and (max-width: 900px) {
        padding: 0 30px;
        justify-content: space-between;
      }

      li {
        font-size: 1.4em;
        color: ${theme.colors.white};
      }
    }
  `}
`;

export const LeftArea = styled.div`
  ${({ theme }) => css`
    display: flex;
    align-items: center;
    gap: 8px;
    font-size: 18pt;
    color: ${theme.colors.white};

    a {
      padding-bottom: 5px;
      border-bottom: 1px solid ${theme.colors.orange.main};
    }

    svg {
      &:hover {
        cursor: pointer;
      }
    }
  `}
`;

const RightAreaModifiers = {
  search: () => css`
    svg {
      display: none;
    }
  `
};

type RightAreaProps = {
  search: boolean;
};
export const RightArea = styled.div<RightAreaProps>`
  ${({ theme, search }) => css`
    display: flex;
    gap: 1.5rem;

    #searchButton {
      display: none;
    }

    ${!!search && RightAreaModifiers.search}

    @media (max-width: 475px) {
      #searchButton {
        display: ${search ? 'none' : 'block'};
      }
    }
  `}
`;

export const Cart = styled.li`
  display: flex;
  align-items: center;
  gap: 1.5rem;
  height: 24px;

  span {
    font-size: 80%;
  }

  @media (max-width: 475px) {
    span {
      display: none;
    }
  }
`;

export const Account = styled.li``;

type SearchProps = {
  search: boolean;
};
export const Search = styled.div<SearchProps>`
  ${({ theme, search }) => css`
    position: absolute;
    width: 100%;
    padding: 10px;
    display: ${search ? 'flex' : 'none'};
    align-items: center;
    gap: 8px;

    input {
      background-color: ${theme.colors.gray.dark};
      padding: 25px;
      border-radius: 8px;
      color: ${theme.colors.white};
      flex: 1;
    }
  `}
`;
