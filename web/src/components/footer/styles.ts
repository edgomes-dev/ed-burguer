import styled, { css } from "styled-components";

export const Container = styled.div`
  ${({ theme }) => css`
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: ${theme.spacings.small};
  `}
`;
