import styled, { css } from "styled-components";

export const Container = styled.div`
  display: flex;
  justify-content: space-around;
`;

export const Image = styled.img`
  width: 30rem;
  height: 25rem;
  object-fit: coxntain;
`;

export const Details = styled.div`
  ${({ theme }) => css`
    position: relative;
    width: 10rem;
    background-color: red;

    p {
      position: absolute;
      width: 100%;
      text-align: center;
      bottom: 50%;
    }
  `}
`;

export const Link = styled.a`
  ${({ theme }) => css`
    position: absolute;
    width: 100%;
    padding: ${theme.spacings.xsmall};
    background-color: green;
    left: 0;
    bottom: 0;
  `}
`;

export const Card = styled.div`
  display: flex;
  justify-content: space-around;
`;
