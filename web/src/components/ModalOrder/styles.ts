import styled, { createGlobalStyle, css } from 'styled-components';

interface IWrapperProps {
  visible: boolean;
}

export const Wrapper = styled.div<IWrapperProps>`
  ${({ theme, visible }) => css`
    display: ${visible ? 'block' : 'none'};
    position: fixed;
    width: 450px;
    height: 400px;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: ${theme.colors.gray.medium};
    color: white;
  `}
`;

export const Menu = styled.div`
  display: flex;
  align-items: center;
  width: 80%;
  margin: 0 auto;
  margin-top: 3rem;
  gap: 4rem;
`;

export const Content = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  gap: 2rem;
  height: 100%;

  .address {
    flex-direction: column;
  }
`;

export const Item = styled.button`
  ${({ theme }) => css`
    display: flex;
    align-items: center;
    gap: 2rem;
    box-sizing: content-box;
    background-color: ${theme.colors.gray.dark};
    padding: 1.5rem;
    border-radius: 8px;
    box-shadow: rgba(0, 0, 0, 0.4) 3px 3px 8px 0px;
    width: 70%;
    color: ${theme.colors.white};
    font-size: 13pt;
    cursor: pointer;
    transition: ${theme.transition.fast};

    &:hover {
      background-color: ${theme.colors.gray.medium};
    }
  `}
`;
