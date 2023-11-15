import { css, styled } from 'styled-components';

export const Wrapper = styled.div`
  ${({ theme }) => css`
    width: 100%;
    height: 100vh;
    background-color: ${theme.colors.white};
  `}
`;

export const Content = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 15rem;

  h2 {
    //text-align: center;
    margin-bottom: 2rem;
  }
`;

export const Form = styled.div`
  ${({ theme }) => css`
    width: 100%;
    max-width: 40rem;
    box-sizing: content-box;
    padding: 5rem 10rem;
    background-color: #fff;

    img {
      display: block;
      margin: 0 auto;
      margin-bottom: 2.5rem;
      border-radius: 30px;
    }

    form {
      display: flex;
      flex-direction: column;
      width: 400px;
      display: flex;
      gap: 2rem;

      input {
        border: none;
        border-bottom: 1px solid black;
        background-color: ${theme.colors.gray.lighther};
        padding: 2rem;
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
  `}
`;
