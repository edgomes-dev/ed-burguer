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

    a {
      background-color: ${theme.colors.orange.main};
      color: ${theme.colors.white};
      margin-top: 2rem;
      font-size: 12pt;
      font-weight: bolder;
      padding: 11px 16px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      transition: ${theme.transition.default};
      text-decoration: none;
      display: flex;
      align-items: center;
      gap: 8px;

      &:hover {
        background-color: ${theme.colors.orange.dark};
      }
    }
  `}
`;

export const Product = styled.div`
  ${({ theme }) => css`
    display: grid;
    grid-template-columns: 500px 100px;
    grid-template-areas:
      'leftArea rightArea'
      'observation observation';
    background-color: ${theme.colors.gray.light};
    margin-bottom: 20px;
  `}
`;

export const LeftArea = styled.div`
  display: flex;
  position: relative;
  grid-area: leftArea;

  img {
    margin-right: 10px;
  }

  span {
    font-size: 9pt;
  }

  .priceArea {
    display: flex;
    align-items: center;
    gap: 10px;
    position: absolute;
    bottom: 2px;
    font-weight: bolder;
  }
`;

export const RightArea = styled.div`
  ${({ theme }) => css`
    position: relative;
    grid-area: rightArea;

    div {
      position: absolute;
      right: 0;
      background-color: ${theme.colors.orange.main};
      padding: 5px 15px;
      border-radius: 0 0 0 10px;
      transition: ${theme.transition.default};
      cursor: pointer;

      &:hover {
        background-color: ${theme.colors.orange.dark};
      }
    }

    #twoIcon {
      position: absolute;
      border-radius: 10px 0 0 0;
      bottom: 0;
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
    display: flex;
    gap: 3rem;
  `}
`;

export const ProductArea = styled.div``;

export const ProductResume = styled.div`
  ${({ theme }) => css`
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

export const ProductResumeDelivery = styled.div``;

export const ProductResumeContent = styled.div`
  ${({ theme }) => css`
    width: 300px;
    border: 2px solid ${theme.colors.gray.lighther};
    background-color: ${theme.colors.gray.light};

    h3 {
      text-align: center;
      border-bottom: 2px solid ${theme.colors.gray.lighther};
    }

    .item {
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 0 10px;
    }

    .total {
      display: flex;
      justify-content: space-between;
      align-items: center;
      background-color: ${theme.colors.gray.dark};
      border-top: 2px solid ${theme.colors.gray.lighther};
      padding: 0 10px;

      h3 {
        border-bottom: none;
      }
    }
  `}
`;
