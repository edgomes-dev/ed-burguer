import { styled } from 'styled-components';

export const Wrapper = styled.div`
  position: absolute;
  z-index: 1;
  top: 20vh;
  right: 35vw;
  width: 600px;
  padding: 5rem;
  background-color: black;
  color: white;
  overflow: hidden;
`;

export const Title = styled.div`
  position: relative;
  display: flex;
  align-items: center;
  justify-content: center;
`;

export const Close = styled.button`
  position: absolute;
  cursor: pointer;
  right: 0;
  color: white;
  background-color: black;
  font-size: 1.2em;
`;

export const Text = styled.p`
  background-color: red;
  border: 1px solid red;
  margin: 2rem 0;
`;

export const DateItem = styled.div`
  display: flex;
  justify-content: space-between;
`;
