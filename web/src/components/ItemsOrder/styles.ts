import styled, { css } from 'styled-components';

export const Wrapper = styled.div`
  ${({ theme }) => css`
    color: ${theme.colors.white};

    h2 {
      display: inline-block;
      padding-bottom: 1rem;
      border-bottom: 2px solid ${theme.colors.orange.main};
    }
  `}
`;

export const Product = styled.div`
  ${({ theme }) => css`
    display: grid;
    grid-template-columns: 500px 1fr;
    grid-template-areas:
      'leftArea rightArea'
      'observation observation';
    background-color: ${theme.colors.gray.light};
    margin-top: 20px;
  `}
`;

export const ProductOptional = styled.div`
  ${({ theme }) => css`
    background-color: ${theme.colors.gray.light};

    div {
      display: flex;
      justify-content: space-between;
      padding: 0 15px;
    }
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
