import styled from "styled-components";

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
  }
`;

export const Icone = styled.p`
  color: orange;

  span {
    color: red;
  }
`;
