import { css, styled } from 'styled-components';

type WrapperProps = {
  visible: boolean;
};
export const Wrapper = styled.div<WrapperProps>`
  ${({ visible }) => css`
    position: fixed;
    width: 100vw;
    height: 100vh;
    z-index: 1;
    color: white;
    display: ${visible ? 'grid' : 'none'};
    grid-template-columns: 400px 1fr;

    @media (max-width: 475px) {
      display: ${visible ? 'block' : 'none'};
    }
  `}
`;

export const Content = styled.div`
  ${({ theme }) => css`
    height: 100vh;
    background-color: ${theme.colors.gray.light};

    img {
      border-radius: 15px;
      margin: 20px 25%;
    }

    .active {
      background-color: ${theme.colors.orange.main};
    }

    .closeIcon {
      position: absolute;
      top: 20px;
      left: 20px;
      cursor: pointer;
    }
  `}
`;

export const IconContainer = styled.div`
  display: flex;
  align-items: center;
  gap: 5px;
`;

export const HourItem = styled.div`
  display: flex;
  justify-content: space-between;
`;

export const Overlay = styled.div`
  display: block;
  background-color: black;
  opacity: 0.5;
`;
