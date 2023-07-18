import { css, styled } from 'styled-components';

export const Wrapper = styled.div`
  ${({ theme }) => css`
    background-color: ${theme.colors.gray.background};
    color: ${theme.colors.white};
    height: 100vh;
  `}
`;

export const Ingredients = styled.div``;

export const Form = styled.form`
  max-width: 70rem;
  margin: 0 auto;

  h2 {
    text-align: center;
  }

  select {
    border: none;
    overflow: hidden;
    font-size: 1em;
    width: 100%;
  }

  input {
    width: 100%;
  }
`;
