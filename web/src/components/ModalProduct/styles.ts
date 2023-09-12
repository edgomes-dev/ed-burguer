import { css, styled } from 'styled-components';

type WrapperProps = {
  visible: boolean;
};
export const Wrapper = styled.div<WrapperProps>`
  ${({ theme, visible }) => css`
    display: ${visible ? 'block' : 'none'};
    position: fixed;
    z-index: 1;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    overflow: auto;
    background-color: ${theme.colors.gray.background};
    color: white;

    .close {
      color: ${theme.colors.white};
    }
  `}
`;

export const Menu = styled.div`
  ${({ theme }) => css`
    display: flex;
    justify-content: space-between;
    padding: 3rem;
    font-weight: bolder;

    div {
      div {
        color: ${theme.colors.gray.light};
        text-align: end;
      }
    }
  `}
`;

export const Content = styled.div`
  padding: 3rem;

  .image {
    display: flex;
    justify-content: center;

    img {
      border-radius: 16px;
    }
  }

  .description {
    margin: 2.5rem 0;
  }
`;

export const OptionContainer = styled.div``;

export const Footer = styled.div`
  ${({ theme }) => css`
    display: flex;
    padding: 2rem;
    justify-content: space-between;
    border-top: 1px solid ${theme.colors.gray.medium};
  `}
`;

export const Observation = styled.div`
  ${({ theme }) => css`
    textarea {
      width: 100%;
      padding: 1rem;
      background-color: ${theme.colors.gray.dark};
    }
  `}
`;

export const Counter = styled.div`
  ${({ theme }) => css`
    font-size: 14pt;
    text-align: center;
  `}
`;

export const Button = styled.div`
  ${({ theme }) => css`
    display: flex;
    align-items: center;
    gap: 1.25rem;
    background-color: ${theme.colors.orange.main};
    padding: 1rem 4rem;
    border-radius: 10px;
    transition: ${theme.transition.default};
    user-select: none;

    &:hover {
      background-color: ${theme.colors.orange.dark};
    }
  `}
`;

/*

p {
      user-select: none;
    }

    div {
      display: grid;
      width: 125px;
      height: 50px;
      grid-template-columns: repeat(3, 1fr);
      align-items: center;
      border: 1px solid ${theme.colors.gray.light};
      border-radius: 8px;

      span {
        display: flex;
        align-items: center;
        justify-content: center;
        height: 100%;

        &:hover {
          background-color: ${theme.colors.orange.main};
        }
      }
    }

*/
