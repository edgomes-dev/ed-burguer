import styled, { DefaultTheme, css } from 'styled-components';
import { CounterProps } from '.';

const wrapperModifiers = {
  small: (theme: DefaultTheme) => css`
    display: grid;
    width: 80px;
    height: 35px;
    grid-template-columns: repeat(3, 1fr);
    align-items: center;
    border: 1px solid ${theme.colors.gray.light};
    border-radius: 4px;
    justify-content: center;
    text-align: center;

    button {
      display: flex;
      align-items: center;
      justify-content: center;
      height: 100%;
      background-color: transparent;
      color: ${theme.colors.white};
      font-size: 14pt;
      border: none;
      border-radius: 4px;

      &:hover {
        background-color: ${theme.colors.orange.main};
      }
    }
  `,
  large: (theme: DefaultTheme) => css`
    display: grid;
    width: 125px;
    height: 50px;
    grid-template-columns: repeat(3, 1fr);
    align-items: center;
    border: 1px solid ${theme.colors.gray.light};
    border-radius: 8px;

    button {
      display: flex;
      align-items: center;
      justify-content: center;
      height: 100%;
      background-color: transparent;
      color: ${theme.colors.white};
      font-size: 16pt;
      border: none;
      border-radius: 8px;

      &:hover {
        background-color: ${theme.colors.orange.main};
      }
    }
  `
};

type WrapperProps = Pick<CounterProps, 'size'>;

export const Wrapper = styled.div<WrapperProps>`
  ${({ theme, size }) => css`
    ${!!size && wrapperModifiers[size](theme)}

    background-color: ${theme.colors.gray.light};
    p {
      user-select: none;
    }
  `}
`;
