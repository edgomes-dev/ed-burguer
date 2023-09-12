import { css, styled } from 'styled-components';

export const Wrapper = styled.div``;

export const Title = styled.div`
  ${({ theme }) => css`
    display: flex;
    justify-content: space-between;
    align-items: center;
    color: ${theme.colors.text};

    button {
      background-color: transparent;
      border: none;
      cursor: pointer;
      color: ${theme.colors.text};
    }
  `}
`;

export const Slider = styled.div`
  margin-left: 20px;
  display: flex;
  width: 100%;
  overflow-x: auto;
  scroll-behavior: smooth;
  gap: 20px;

  &::-webkit-scrollbar {
    display: none;
  }
`;

export const Item = styled.div`
  ${({ theme }) => css`
    background-color: ${theme.colors.gray.dark};
    color: white;
    padding: 16px;
    width: 150px;
    height: 150px;
    border-radius: 10px;
    flex: none;

    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    text-align: center;
  `}
`;

export const Buttons = styled.div``;
