import { styled } from 'styled-components';

export const Wrapper = styled.div``;

export const Form = styled.div`
  max-width: 40rem;

  form {
    display: flex;
    flex-direction: column;

    label {
      display: flex;
      flex-direction: column;

      input {
        border: none;
        padding-bottom: 1rem;
        border-bottom: 1px solid black;
      }
    }

    input[type='submit'] {
      margin-top: 5rem;
      border: none;
      background-color: red;
      color: white;
      font-weight: bolder;
      padding: 1rem;
      border-radius: 1.3rem;
    }
  }
`;
