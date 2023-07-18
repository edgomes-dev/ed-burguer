import { styled } from 'styled-components';

export const Wrapper = styled.div`
  width: 100vw;
  height: 100vh;
  display: grid;
  grid-template-columns: 400px 1fr;
  grid-template-rows: 100px 1fr;
  grid-template-areas:
    'menuLeft menu'
    'menuLeft content';
`;

export const Content = styled.div`
  width: 100%;
  grid-area: content;
`;
