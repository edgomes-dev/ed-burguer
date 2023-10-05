import { css, styled } from 'styled-components';

export const Wrapper = styled.div`
  .slider-active {
    color: red;
  }
`;

export const Title = styled.div`
  ${({ theme }) => css`
    display: flex;
    justify-content: space-between;
    width: 90%;
    align-items: center;
    color: ${theme.colors.white};
    margin: 3rem auto;

    button {
      background-color: transparent;
      border: none;
      cursor: pointer;
      color: ${theme.colors.white};
    }

    @media (min-width: 500px) and (max-width: 900px) {
      h2 {
        font-size: 15pt;
      }
    }

    @media (max-width: 475px) {
      h2 {
        font-size: 13pt;
      }

      button {
        background-color: ${theme.colors.orange.main};
        font-size: 11pt;
        font-weight: bolder;
        padding: 6px;
        border-radius: 4px;
      }
    }
  `}
`;

export const Slider = styled.div`
  display: flex;
  width: 100%;
  overflow-x: auto;
  scroll-behavior: smooth;
  gap: 20px;

  &::-webkit-scrollbar {
    display: none;
  }

  @media (max-width: 475px) {
    display: none;
  }
`;

export const Item = styled.div`
  ${({ theme }) => css`
    background-color: ${theme.colors.gray.light};
    color: white;
    padding: 1.5rem;
    width: 175px;
    height: 175px;
    border-radius: 10px;
    flex: none;

    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    text-align: center;
  `}
`;

export const SliderMobile = styled.div`
  ${({ theme }) => css`
    display: flex;
    background-color: ${theme.colors.gray.light};

    nav {
      display: flex;

      li {
        list-style: none;
      }
    }
  `}
`;
