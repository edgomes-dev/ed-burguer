import styled, { css } from 'styled-components';

export const Wrapper = styled.div`
  ${({ theme }) => css`
    color: ${theme.colors.white};
  `}
`;

export const Menu = styled.div`
  ${({ theme }) => css`
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin: 50px 60px;

    svg {
      color: ${theme.colors.white};
      font-size: 17pt;
    }
  `}
`;

export const Button = styled.input`
  ${({ theme }) => css`
    background-color: ${theme.colors.orange.main};
    color: ${theme.colors.white};
    font-size: 12pt;
    font-weight: bolder;
    padding: 11px 16px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: ${theme.transition.default};

    &:hover {
      background-color: ${theme.colors.orange.dark};
    }
  `}
`;

export const Content = styled.div`
  ${({ theme }) => css`
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;

    .title {
      font-size: 20pt;
      color: ${theme.colors.orange.main};
      font-weight: bolder;
      margin-top: 4rem;
    }
  `}
`;

export const Observation = styled.div`
  ${({ theme }) => css`
    margin-top: 2.5rem;
    grid-area: observation;

    textarea {
      width: 80%;
      height: 100px;
      padding: 8px;
      background-color: ${theme.colors.gray.lighther};
      resize: none;
      box-shadow: rgba(0, 0, 0, 0.2) 2px 2px 4px 0px;
      border: 1px solid rgb(44, 44, 48);
      font-size: 16px;
      color: ${theme.colors.white};
    }
  `}
`;

export const ProductContent = styled.div`
  ${({ theme }) => css`
    width: 850px;

    input {
      background-color: ${theme.colors.orange.main};
      color: ${theme.colors.white};
      font-size: 12pt;
      margin-top: 1.5rem;
      width: 100%;
      font-weight: bolder;
      padding: 11px 16px;
      border: none;
      cursor: pointer;
      transition: ${theme.transition.default};

      &:hover {
        background-color: ${theme.colors.orange.dark};
      }
    }
  `}
`;

export const ProductFinish = styled.div`
  ${({ theme }) => css`
    padding-bottom: 5rem;

    .totalPrice {
      display: flex;
      margin-top: 3rem;
      justify-content: space-between;
      font-size: 20pt;
      padding-bottom: 10px;
      border-bottom: 2px solid;
    }

    .link {
      margin-top: 3rem;

      a {
        display: flex;
        align-items: center;
        justify-content: center;
        gap: 5px;
        color: ${theme.colors.gray.light};
      }
    }
  `}
`;
