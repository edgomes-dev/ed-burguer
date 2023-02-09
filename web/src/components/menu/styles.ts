import styled, { css } from "styled-components";

export const Container = styled.nav`
  display: flex;
  width: 100%;
  height: 12rem;
  background-color: green;
  justify-content: space-around;
  align-items: center;

  ul {
    display: flex;
    width: 400px;
    justify-content: space-between;
    list-style: none;

    li {
      a {
        color: orange;
        font-size: 1.2em;
        text-decoration: none;
      }
    }
  }

  div {
    ${({ theme }) => css`
      display: flex;
      align-items: center;
      gap: ${theme.spacings.small};
    `}

    a {
      ${({ theme }) => css`
        color: white;
        text-decoration: none;
        background-color: black;
        padding: ${theme.spacings.xsmall};
        border-radius: ${theme.border.radius};
      `}
    }
  }
`;

export const Icone = styled.p`
  font-size: 1.8em;

  a {
    text-decoration: none;
    color: orange;
  }

  span {
    color: red;
  }
`;
