import { css, styled } from 'styled-components';

export const Wrapper = styled.div`
  ${({ theme }) => css`
    width: 100%;
    min-height: 100vh;
    background-color: ${theme.colors.white};
  `}
`;

export const Content = styled.div`
  width: 100%;
  height: 100%;
  padding-top: 60px;
  padding-left: 12%;
`;
