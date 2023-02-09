import styled, { css } from "styled-components";

export const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
`;

export const Form = styled.form`
  ${({ theme }) => css`
    width: 35rem;
    padding: ${theme.spacings.xxlarge};
    background-color: red;
    border-radius: ${theme.border.radius};

    div {
      display: flex;
      flex-direction: column;
      gap: 5px;
    }

    input[type="submit"] {
      padding: ${theme.spacings.xxsmall};
      border-radius: ${theme.border.radius};
      background-color: orange;
    }
  `}
`;
