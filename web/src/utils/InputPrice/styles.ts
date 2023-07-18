import { css, styled } from 'styled-components';

export const Wrapper = styled.label`
  cursor: pointer;

  input {
    display: none;
  }

  input:checked + div {
    background-color: red;

    div {
      span {
        visibility: visible;
      }
    }
  }
`;

export const Content = styled.div`
  display: flex;
  justify-content: space-between;
`;

export const Price = styled.div`
  display: flex;
  align-items: center;
  gap: 1.25rem;

  span {
    visibility: hidden;
  }
`;
