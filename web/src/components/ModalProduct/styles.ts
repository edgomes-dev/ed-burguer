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
    background-color: ${theme.colors.gray.medium};
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
        color: ${theme.colors.gray.lighther};
        font-weight: bolder;
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
    background-color: ${theme.colors.gray.dark};
  `}
`;

export const Observation = styled.div`
  ${({ theme }) => css`
    textarea {
      width: 100%;
      height: 100px;
      padding: 8px;
      background-color: ${theme.colors.gray.light};
      resize: none;
      box-shadow: rgba(0, 0, 0, 0.2) 2px 2px 4px 0px;
      border: 1px solid rgb(44, 44, 48);
      font-size: 16px;
      color: ${theme.colors.white};
    }
  `}
`;

export const Counter = styled.div`
  ${({ theme }) => css`
    font-size: 14pt;
    text-align: center;

    @media (max-width: 475px) {
      p {
        font-size: 12pt;
      }
    }
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

    @media (max-width: 475px) {
      padding: 0.5rem 2rem;
    }
  `}
`;
